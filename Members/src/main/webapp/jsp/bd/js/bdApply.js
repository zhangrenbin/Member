function init() {
	$("#bdFrm").validate({
		rules: {
			bRemark: {
				required: true,
				maxlength:200
			}
		}
	});
	$("#applyBtn").click(function() {
		if(!$('#bdFrm').valid()) e.preventDefault();
		$("#bdFrm").attr("action","bd/f_bd_apply/sub.do");
	});
}
init();