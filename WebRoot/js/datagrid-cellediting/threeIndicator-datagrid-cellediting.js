//传入jQuery参数，让这个私有空间能够使用$或者jQuery
(function($){
	//对datagrid默认属性的扩展
	$.extend($.fn.datagrid.defaults, {
		lastCell:{},      //最近一次点击到单元格参数
		clickToEdit: true,    //新增属性：单击可编辑
		dblclickToEdit: false,  //新增属性：双击可编辑
		navHandler: {          //当需要调用按键对应的事件处理程序时，只需要navHandler[e.keyCode]即可
			//上下左右按键相应的处理动作
			'37': function(e){
				var opts = $(this).datagrid('options');
				return navHandler.call(this, e, opts.isRtl?'right':'left');
			},
			'39': function(e){
				var opts = $(this).datagrid('options');
				return navHandler.call(this, e, opts.isRtl?'left':'right');
			},
			'38': function(e){
				return navHandler.call(this, e, 'up');
			},
			'40': function(e){
				return navHandler.call(this, e, 'down');
			},
			//回车和ESC按键的处理动作
			'13': function(e){
				return doneHandler.call(this, e, true);
			},
			'27': function(e){
				return doneHandler.call(this, e, false);
			},
			//删除按键的处理动作
			'8': function(e){
				return clearHandler.call(this, e);
			},
			'46': function(e){
				return clearHandler.call(this, e);
			},
			'keypress': function(e){    //输入
				var dg = $(this);
				var param = dg.datagrid('cell');	// 当前单元格的行索引和列名
				if (!param){return;}
				var input = dg.datagrid('input', param);
				if (!input){       //如果没有获取到编辑器
					var tmp = $('<span></span>');
					tmp.html(String.fromCharCode(e.which));
					var c = tmp.text();
					tmp.remove();
					if (c){
						dg.datagrid('editCell', {
							index: param.index,
							field: param.field,
							value: c
						});
						return false;						
					}
				}
			}
		},
		onBeforeCellEdit: function(index, field){},
		onCellEdit: function(index, field, value){
			var input = $(this).datagrid('input', {index:index, field:field});
			if (input){
				if (value != undefined){
					input.val(value);
				}
			}
		}
	});

	function navHandler(e, dir){
		var dg = $(this);
		var param = dg.datagrid('cell');
		var input = dg.datagrid('input', param);
		if (!input){
			dg.datagrid('gotoCell', dir);
			return false;
		}
	}

	function doneHandler(e, accepted){
		var dg = $(this);
		var opts = dg.datagrid('options');
		var param = dg.datagrid('cell');
		if (!param){return;}
		var input = dg.datagrid('input', param);
		if (input){
			if (accepted){
				if (dg.datagrid('validateRow', param.index)){
					dg.datagrid('endEdit', param.index).datagrid('gotoCell', param);
				} else {
					input.focus();
				}
			} else {
				dg.datagrid('cancelEdit', param.index).datagrid('gotoCell', param);
			}
		} else if (accepted){
			dg.datagrid('editCell', param);
			var editor = dg.datagrid('getEditor',{index:param.index,field:param.field});
			$(editor.target).bind('blur',function(e){
				e.stopPropagation();    //阻止事件冒泡
				$(editor.target).unbind('blur');
				opts.renderFlag = false;
				opts.lastCell = param;
				dg.datagrid('endEdit',param.index);
				opts.renderFlag = true;
			});
		}
		return false;
	}

	function clearHandler(e){
		var dg = $(this);
		var param = dg.datagrid('cell');
		if (!param){return;}
		var input = dg.datagrid('input', param);
		if (!input){
			dg.datagrid('editCell', {
				index: param.index,
				field: param.field,
				value: ''
			});
			return false;
		}		
	}
	//返回单元格的行索引和列名
	function getCurrCell(target){   //target是DOM对象
		var cell = $(target).datagrid('getPanel').find('td.datagrid-row-selected');
		if (cell.length){
			return {
				index: parseInt(cell.closest('tr.datagrid-row').attr('datagrid-row-index')),
				field: cell.attr('field')
			};
		} else {
			return null;
		}
	}

	function unselectCell(target, p){
		var opts = $(target).datagrid('options');
		var cell = opts.finder.getTr(target, p.index).find('td[field="'+p.field+'"]');
		cell.removeClass('datagrid-row-selected');
	}

	function unselectAllCells(target){
		var panel = $(target).datagrid('getPanel');
		panel.find('td.datagrid-row-selected').removeClass('datagrid-row-selected');
	}

	function selectCell(target, p){
		var opts = $(target).datagrid('options');
		if (opts.singleSelect){
			unselectAllCells(target);
		}
		var cell = opts.finder.getTr(target, p.index).find('td[field="'+p.field+'"]');
		cell.addClass('datagrid-row-selected');
	}

	function getSelectedCells(target){
		var cells = [];
		var panel = $(target).datagrid('getPanel');
		panel.find('td.datagrid-row-selected').each(function(){
			var td = $(this);
			cells.push({
				index: parseInt(td.closest('tr.datagrid-row').attr('datagrid-row-index')),
				field: td.attr('field')
			});
		});
		return cells;
	}

	function gotoCell(target, p){
		var dg = $(target);
		var opts = dg.datagrid('options');
		var panel = dg.datagrid('getPanel').focus();
		var cparam = dg.datagrid('cell');
		if (cparam){
			var input = dg.datagrid('input', cparam);
			if (input){
				input.focus();
				return;
			}
		}
		if (typeof p == 'object'){
			_go(p);
			return;
		}
		var cell = panel.find('td.datagrid-row-selected');
		if (!cell){return;}
		var fields = dg.datagrid('getColumnFields',true).concat(dg.datagrid('getColumnFields'));
		var field = cell.attr('field');
		var tr = cell.closest('tr.datagrid-row');
		var rowIndex = parseInt(tr.attr('datagrid-row-index'));
		var colIndex = $.inArray(field, fields);
		if (p == 'up' && rowIndex > 0){
			rowIndex--;
		} else if (p == 'down' && rowIndex < dg.datagrid('getRows').length-1){
			rowIndex++;
		} else if (p == 'left'){
			var i = colIndex - 1;
			while(i >= 0){
				var col = dg.datagrid('getColumnOption', fields[i]);
				if (!col.hidden){
					colIndex = i;
					break;
				}
				i--;
			}
		} else if (p == 'right'){
			var i = colIndex + 1;
			while(i <= fields.length-1){
				var col = dg.datagrid('getColumnOption', fields[i]);
				if (!col.hidden){
					colIndex = i;
					break;
				}
				i++;
			}
		}

		field = fields[colIndex];

		_go({index:rowIndex, field:field});

		function _go(p){
			var td = opts.finder.getTr(target, p.index).find('td[field="'+p.field+'"]');
			if (td.length){
				dg.datagrid('scrollTo', p.index);
				unselectAllCells(target);
				selectCell(target, p);
				var body2 = dg.data('datagrid').dc.body2;
				var left = td.position().left;
				if (left < 0){
					body2._scrollLeft(body2._scrollLeft() + left*(opts.isRtl?-1:1));
				} else if (left+td._outerWidth()>body2.width()){
					body2._scrollLeft(body2._scrollLeft() + (left+td._outerWidth()-body2.width())*(opts.isRtl?-1:1));
				}
			}
		}
	}

	function editCell(target, param){
		var dg = $(target);
		var opts = dg.datagrid('options');
		var cell = dg.datagrid('cell');       //已选中的单元格
		if (cell){     //如果之前已经选中了单元格
			var input = dg.datagrid('input', cell);
			if (input){
				if (cell.index == param.index && cell.field == param.field){
					dg.datagrid('gotoCell', cell);
					input.focus();
					return;
				} else {
					if (dg.datagrid('validateRow', cell.index)){
						dg.datagrid('endEdit', cell.index);
					} else {
						dg.datagrid('gotoCell', cell);
						input.focus();
						return;
					}
				}
			}
		}
		if (opts.onBeforeCellEdit.call(target, param.index, param.field) == false){
			return;
		}
		var fields = dg.datagrid('getColumnFields',true).concat(dg.datagrid('getColumnFields'));
		$.map(fields, function(field){        //对列编辑器进行处理
			var col = dg.datagrid('getColumnOption', field);
			col.editor1 = col.editor;
			if (field != param.field){
				col.editor = null;
			}
		});
		dg.datagrid('beginEdit', param.index);
		var input = dg.datagrid('input', param);
		if (input){
			dg.datagrid('gotoCell', param);
            input.focus();
            //为当前点击的input绑定文本改变监听事件
            input.bind('input',function(e){
            	e.stopPropagation();    //阻止事件冒泡
            	var title = parent.IsExistTab2(opts.title);
            	if(title){
    				parent.updTabTitle(title);
    			}
            });
            //input为当前点击的cell的文本框,为其绑定ctrl+v组合键事件
            input.bind('keydown',function(){
            	var e = window.event || arguments.callee.caller.arguments[0];
            	if (e && e.keyCode == 86 && e.ctrlKey ) {
            			var textarea = $("#pasteArea");
            			//判断textarea域的display属性
            			var display = textarea.css('display');
            			if(display == 'none'){
            				textarea.css('display','block');
            			}
            			//在当前单元格失去焦点前获取该单元格参数
            			opts.lastCell = dg.datagrid('cell');
            	    	textarea.focus(); 
            	    }
            });
            opts.onCellEdit.call(target, param.index, param.field, param.value);
		} else {
			dg.datagrid('cancelEdit', param.index);
			dg.datagrid('gotoCell', param);
		}

		$.map(fields, function(field){
			var col = dg.datagrid('getColumnOption', field);
			col.editor = col.editor1;
		});
	}

	function enableCellSelecting(target){
		var dg = $(target);
		var state = dg.data('datagrid');
		var panel = dg.datagrid('getPanel');
		var opts = state.options;
		var dc = state.dc;
		panel.attr('tabindex',1).css('outline-style','none').unbind('.cellediting').bind('keydown.cellediting', function(e){
			var h = opts.navHandler[e.keyCode];
			if (h){
				return h.call(target, e);
			}
		});
		dc.body1.add(dc.body2).unbind('.cellediting').bind('click.cellediting', function(e){
			var tr = $(e.target).closest('.datagrid-row');
			if (tr.length && tr.parent().length){
				var td = $(e.target).closest('td[field]', tr);
				if (td.length){
					var index = parseInt(tr.attr('datagrid-row-index'));
					var field = td.attr('field');
					var p = {
						index: index,
						field: field
					};
					if (opts.singleSelect){
						selectCell(target, p);
					} else {
						if (opts.ctrlSelect){
							if (e.ctrlKey){
								if (td.hasClass('datagrid-row-selected')){
									unselectCell(target, p);
								} else {
									selectCell(target, p);
								}
							} else {
								unselectAllCells(target);
								selectCell(target, p);
							}
						} else {
							if (td.hasClass('datagrid-row-selected')){
								unselectCell(target, p);
							} else {
								selectCell(target, p);
							}
						}
					}
				}
			}
		});

		opts.isRtl = dg.datagrid('getPanel').css('direction').toLowerCase()=='rtl';
		opts.OldOnBeforeSelect = opts.onBeforeSelect;
		opts.onBeforeSelect = function(){
			return false;
		};
		dg.datagrid('clearSelections');
	}

	function disableCellSelecting(target){
		var dg = $(target);
		var state = dg.data('datagrid');
		var panel = dg.datagrid('getPanel');
		var opts = state.options;
		opts.onBeforeSelect = opts.OldOnBeforeSelect || opts.onBeforeSelect;
		panel.unbind('.cellediting').find('td.datagrid-row-selected').removeClass('datagrid-row-selected');
		var dc = state.dc;
		dc.body1.add(dc.body2).unbind('cellediting');
	}
	//单击的单元格启用编辑
	function enableCellEditing(target){
		var flag='';   //标志着点击的单元格是不是在主要信息类,如果是置为'flag'，否则置为''
		var dg = $(target);
		var opts = dg.datagrid('options');
		var panel = dg.datagrid('getPanel');  //获取panel对象
		panel.attr('tabindex',1).css('outline-style','none').unbind('.cellediting').bind('keydown.cellediting', function(e){
			//为其注册了键盘点击事件，当出现键盘点击事件就会自动触发这个事件
			var h = opts.navHandler[e.keyCode];
			if (h){
				return h.call(target, e);
			}
		}).bind('keypress.cellediting', function(e){
			return opts.navHandler['keypress'].call(target, e);
		});
		panel.panel('panel').unbind('.cellediting').bind('keydown.cellediting', function(e){
			e.stopPropagation();    //阻止事件冒泡
		}).bind('keypress.cellediting', function(e){
			e.stopPropagation();
		});
		
		opts.isRtl = dg.datagrid('getPanel').css('direction').toLowerCase()=='rtl';
		opts.oldOnClickCell = opts.onClickCell;
		opts.oldOnDblClickCell = opts.onDblClickCell;
		if (opts.clickToEdit){        //如果是支持单击可编辑
			opts.onClickCell = function(index, field, value){
				if(field != 'type' && field != 'number' && field != 'department'){
					if(index != 11 && index != 20 && index != 23){
						if(isInField(target,field)){   //如果单击的单元格是在主要信息列上面
							flag='flag';
						}
						if(field !='ck'){
							$(this).datagrid('editCell', {index:index,field:field});
							opts.oldOnClickCell.call(this, index, field, value);
							var editor = dg.datagrid('getEditor',{index:index,field:field});
							if(editor){
								$(editor.target).bind('blur',function(e){
									e.stopPropagation();    //阻止事件冒泡
									$(editor.target).unbind('blur');
									opts.renderFlag = false;
									opts.lastCell = dg.datagrid('cell');
									dg.datagrid('endEdit',index);
									opts.renderFlag = true;
								});
							}
						}
					}
				}
			};
		}
		if (opts.dblclickToEdit){
			opts.onDblClickCell = function(index, field, value){
				$(this).datagrid('editCell', {index:index,field:field});
				opts.oldOnDblClickCell.call(this, index, field, value);
			};
		}
		opts.OldOnBeforeSelect = opts.onBeforeSelect;
		//Fires before the user selects a row, return false to cancel this action
		opts.onBeforeSelect = function(){
				if(flag==''){
					return true;
				}
				else{
					flag='';
					return false;
				}
		};
		opts.OldOnBeforeUnselect = opts.onBeforeUnselect;
		opts.onBeforeUnselect = function(){
			if(flag==''){
				return true;
			}else{
				flag='';
				return false;
			}
		};
		dg.datagrid('clearSelections');
	}
	
	//判断点击的cell是不是在主要信息列上（不含checkbox列）
	function isInField(target,field){
		var dg = $(target);
		//获取datagrid的列
		var arr = dg.datagrid('getColumnFields');
		for(var i=0;i<arr.length;i++){
			if(field==arr[i] && field != 'ck'){
				return true;
			}
		}
		return false;
	}
	
	function disableCellEditing(target){
		var dg = $(target);
		var opts = dg.datagrid('options');
		opts.onClickCell = opts.oldOnClickCell || opts.onClickCell;
		opts.onDblClickCell = opts.oldOnDblClickCell || opts.onDblClickCell;
		opts.onBeforeSelect = opts.OldOnBeforeSelect || opts.onBeforeSelect;
		dg.datagrid('getPanel').unbind('.cellediting').find('td.datagrid-row-selected').removeClass('datagrid-row-selected');
	}

	//对datagrid方法的扩展
	//methods中的function总是会接收调用者this这个参数作为第一个实参
	$.extend($.fn.datagrid.methods, {
		editCell: function(jq, param){
			return jq.each(function(){
				editCell(this, param);
			});
		},
		isEditing: function(jq, index){
			var opts = $.data(jq[0], 'datagrid').options;
			var tr = opts.finder.getTr(jq[0], index);
			return tr.length && tr.hasClass('datagrid-row-editing');
		},
		gotoCell: function(jq, param){
			return jq.each(function(){
				gotoCell(this, param);
			});
		},
		enableCellEditing: function(jq){
			return jq.each(function(){
				enableCellEditing(this);
			});
		},
		disableCellEditing: function(jq){
			return jq.each(function(){
				disableCellEditing(this);
			});
		},
		enableCellSelecting: function(jq){
			return jq.each(function(){
				enableCellSelecting(this);
			});
		},
		disableCellSelecting: function(jq){
			return jq.each(function(){
				disableCellSelecting(this);
			});
		},
		input: function(jq, param){       //param参数为options，options参数包含两个特性：index和field 
			if (!param){return null;}
			var ed = jq.datagrid('getEditor', param);   //获取指定的单元格编辑器
			if (ed){
				var t = $(ed.target);
				if (t.hasClass('textbox-f')){      //如果有一个文本框样式
					t = t.textbox('textbox');
				}
				return t;
			} else {
				return null;
			}
		},
		cell: function(jq){		// get current cell info {index,field}
			return getCurrCell(jq[0]);
		},
		getSelectedCells: function(jq){
			return getSelectedCells(jq[0]);
		}
	});

})(jQuery);