$(function(e){
	$.extend(true, $.fn.dataTable.defaults, {
	    searching: false,
	    bServerSide: true,
	    bPaginate: true,
	    orderMulti: false,
	    bInfo: true,
	    dom: "<'row'<'col-sm-12'tr>><'row'<'col-sm-5'i><'col-sm-7'p>>",
	    language: {
	        "sProcessing": "处理中...",
	        "lengthMenu": "显示 _MENU_ 记录",
	        "sZeroRecords": "没有匹配结果",
	        "info": "显示 <b>_START_</b> 到 <b>_END_</b> 共 <b>_TOTAL_</b> 条记录",
	        "sInfoEmpty": "共 0 条记录",
	        "sInfoFiltered": "",
	        "sInfoPostFix": "",
	        "sSearch": "搜索:",
	        "sUrl": "",
	        "sEmptyTable": "表中数据为空",
	        "sLoadingRecords": "载入中...",
	        "sInfoThousands": ",",
	        "oPaginate": {
	            "sFirst": "首页",
	            "sPrevious": "上页",
	            "sNext": "下页",
	            "sLast": "末页"
	        },
	        "oAria": {
	            "sSortAscending": ": 以升序排列此列",
	            "sSortDescending": ": 以降序排列此列"
	        }
	    },
	    columnDefs: [
	        { targets: '_all',orderable: false,searchable: false }
	    ]
	});
	
	//datatables 提交参数和spring mvc整合
	
	var r20 = /%20/g, rbracket = /\[\]$/, rCRLF = /\r?\n/g, rsubmitterTypes = /^(?:submit|button|image|reset|file)$/i, rsubmittable = /^(?:input|select|textarea|keygen)/i;

	function customBuildParams(prefix, obj, traditional, add) {
		var name;

		if (jQuery.isArray(obj)) {
			// Serialize array item.
			jQuery.each(obj, function(i, v) {
				if (traditional || rbracket.test(prefix)) {
					// Treat each array item as a scalar.
					add(prefix, v);

				} else {
					// Item is non-scalar (array or object), encode its numeric
					// index.
					customBuildParams(prefix + "["
							+ (typeof v === "object" ? i : "") + "]", v,
							traditional, add);
				}
			});

		} else if (!traditional && jQuery.type(obj) === "object") {
			// Serialize object item.
			for (name in obj) {
				// This is where the magic happens
				customBuildParams(prefix + "." + name, obj[name], traditional,
						add);
			}

		} else {
			// Serialize scalar item.
			add(prefix, obj);
		}
	}

	$.param = function(a, traditional) {
		var prefix, s = [], add = function(key, value) {
			// If value is a function, invoke it and return its value
			value = jQuery.isFunction(value) ? value() : (value == null ? ""
					: value);
			s[s.length] = encodeURIComponent(key) + "="
					+ encodeURIComponent(value);
		};

		// Set traditional to true for jQuery <= 1.3.2 behavior.
		if (traditional === undefined) {
			traditional = jQuery.ajaxSettings
					&& jQuery.ajaxSettings.traditional;
		}

		// If an array was passed in, assume that it is an array of form
		// elements.
		if (jQuery.isArray(a) || (a.jquery && !jQuery.isPlainObject(a))) {
			// Serialize the form elements
			jQuery.each(a, function() {
				add(this.name, this.value);
			});

		} else {
			// If traditional, encode the "old" way (the way 1.3.2 or older
			// did it), otherwise encode params recursively.
			for (prefix in a) {
				customBuildParams(prefix, a[prefix], traditional, add);
			}
		}

		// Return the resulting serialization
		return s.join("&").replace(r20, "+");
	};
    if($.datetimepicker){
        // 设置日期插件语言
        $.datetimepicker.setLocale('ch');

    }

});
(function($){
    $.extend({
        setTime: function(start,end){
            start.datetimepicker({
                datepicker:true,
                timepicker:false,
                validateOnBlur:false,
                format:'Y-m-d',
                formatDate:'Y-m-d',
                onShow:function( currentDateTime ){
                    this.setOptions({
                        maxDate:end.val()?end.val():false
                    });
                }
            });
            end.datetimepicker({
                datepicker:true,
                timepicker:false,
                validateOnBlur:false,
                format:'Y-m-d',
                formatDate:'Y-m-d',
                onShow:function( currentDateTime ){
                    this.setOptions({
                        minDate:start.val()?start.val():false
                    });
                }
            });
        }
    })
})(jQuery);
/**
 * JQuery validation 插件和bootstrap样式整合
 */
$.validator.setDefaults({
    errorElement: "span",
    errorClass: "help-block",
    highlight: function (element, errorClass, validClass) {
        $(element).closest('.form-group').addClass('has-error');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).closest('.form-group').removeClass('has-error');
    },
    errorPlacement: function (error, element) {
        error.addClass('fa fa-times-circle');
        if (element.parent('.input-group').length || element.prop('type') === 'checkbox' || element.prop('type') === 'radio') {
            error.insertAfter(element.parent());
        } else {
            error.insertAfter(element);
        }
    }
});
if($.datetimepicker){
    //设置datetimepicker语言默认为中文
    $.datetimepicker.setLocale('ch')
}