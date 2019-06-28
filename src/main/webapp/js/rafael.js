function chanr()
{

	document.getElementById("CN").readOnly = false;
	document.getElementById("PN").readOnly = false;
	document.getElementById("PC").readOnly = false;
	document.getElementById("U").readOnly = false;
	document.getElementById("BT").readOnly = false;
	document.getElementById("OPP").readOnly = false;
	document.getElementById("PI").readOnly = false;
	document.getElementById("PP").readOnly = false;
	document.getElementById("UT").readOnly = false;
	document.getElementById("butten").value = "保存";

}

$(document).ready(function (){
	/*$("#but").click(function(){
			console.log($("#updater"));
			$("#updater").css("display","none");
			$("#backr").css("display","block");
			$("#supplierName").removeAttr("readonly");
			$("#supplierContact").removeAttr("readonly");
			$("#supplierPhone").removeAttr("readonly");
			$("#supplierFax").removeAttr("readonly");
			$("#supplierEmail").removeAttr("readonly");
			$("#supplierInfo").removeAttr("readonly");	
			
		
		
	});*/
	$("#button").click(function(){
		$("#CN").removeAttr("readonly");
		$("#PN").removeAttr("readonly");
		$("#PC").removeAttr("readonly");
		$("#BT").removeAttr("readonly");
		$("#OPP").removeAttr("readonly");
		$("#PI").removeAttr("readonly");
		
		$(this).css("display","none");
		$("#ubutton").css("display","inline-block");
		
		
		
	});
	
	$("#ubutton").click(function(){
		$("#PC").attr("readonly","readonly");
		$("#BT").attr("readonly","readonly");
		$("#OPP").attr("readonly","readonly");
		$("#PI").attr("readonly","readonly");
		
		$(this).css("display","none");
		$("#button").css("display","inline-block");
		
		
		var purchaseId = $("#pid").val();
		var productNum = $("#PC").val();
		var orderPurchaseBusinessTime = $("#BT").val();
		var orderPurchasePerson = $("#OPP").val();
		var purchaseInfo = $("#PI").val();
		
		
		$.ajax({
			type: 'get',
			url: 'purchase/update',
			data:{
				"purchaseId":purchaseId,
				"productNum":productNum,
				"orderPurchaseBusinessTime":orderPurchaseBusinessTime,
				"orderPurchasePerson":orderPurchasePerson,
				"purchaseInfo":purchaseInfo
			},
			dataType:'json',
			success:function(result)
			{
				
				alert(result.success);
			},
			error:function()
	          {
	              alert('系统繁忙');
	          }
			
		});
	});
	
	
	
	
	$("#yesr").click(function(){
		var supplierId = $("#sid").val();
		
		 $.ajax({
	          type: 'get',
	          url:'supplier/del',
	          data: {"supplierId":supplierId},
	          dataType: 'json',
	          success:function (result)
	          {
	        	  location.href = "http://localhost:8080/crmsys/supplier/select";
	        	  alert(result.success);
	          },
	          

	      });
	});
	
	$("#opb").click(function(){
		var orderPurchaseTitle = $("#orderPurchaseTitle").val();
		var orderPurchaseTime = $("#orderPurchaseTime").val();
		var supplierId = $("#sel").val();
		var orderPurchaseMoney = $("#orderPurchaseMoney").val();
		var orderPurchaseState = $("#orderPurchaseState").val();
		var orderPurchaseInfo = $("#orderPurchaseInfo").val();
		var orderPurchaseBusinessTime = $("#orderPurchaseBusinessTime").val();
		var orderPurchaseBusinessType = $("#orderPurchaseBusinessType").val();
		var orderPurchaseBusinessAddress = $("#orderPurchaseBusinessAddress").val();
		var orderPurchasePerson = $("#orderPurchasePerson").val();
		
		/*$("#orderPurchaseTitle").attr("readonly","readonly");
		$("#orderPurchaseTime").attr("readonly","readonly");
		$("#supplierId").attr("readonly","readonly");
		$("#orderPurchaseMoney").attr("readonly","readonly");
		$("#orderPurchaseBusinessTime").attr("readonly","readonly");
		$("#orderPurchaseBusinessType").attr("readonly","readonly");
		$("#orderPurchaseBusinessAddress").attr("readonly","readonly");
		$("#orderPurchasePerson").attr("readonly","readonly");*/
		
		$.ajax({
			type:'get',
			url:'purchaseOrder/add',
			data:{
				"orderPurchaseTitle":orderPurchaseTitle,
				"orderPurchaseTime":orderPurchaseTime,
				"supplierId":supplierId,
				"orderPurchaseMoney":orderPurchaseMoney,
				"orderPurchaseState":orderPurchaseState,
				"orderPurchaseInfo":orderPurchaseInfo,
				"orderPurchaseBusinessTime":orderPurchaseBusinessTime,
				"orderPurchaseBusinessType":orderPurchaseBusinessType,
				"orderPurchaseBusinessAddress":orderPurchaseBusinessAddress,
				"orderPurchasePerson":orderPurchasePerson
			},
			dataType:'json',
			success:function(result)
			{
				alert('保存成功');
				$("#opid").val(result.orderPurchaseId);
				console.log(result.orderPurchaseId);
			},
			error:function()
	        {
	              alert('系统繁忙');
	        }
			
			
		})
		
		
	});
	
	$("#sel").change(function(){

		var supplierId = $(this).val();
		
		$.ajax({
			type:'post',
			url:'purchaseOrder/getSupplier',
			data:{
				"supplierId":supplierId
			},
			dataType:'json',
			success:function(result)
			{
				
				$("#supplierPhone").val(result.supplierBean.supplierPhone);
				$("#supplierFax").val(result.supplierBean.supplierFax);
				$("#supplierEmail").val(result.supplierBean.supplierEmail);
				$("#supplierContact").val(result.supplierBean.supplierContact);
				
			},
			error:function()
	        {
	              alert('系统繁忙');
	        }
		});
	});
	
	
	$("#sed").change(function(){

		var commodityNumber = $(this).val();
		
		$.ajax({
			type:'get',
			url:'purchaseOrder/getStock',
			data:{
				"commodityNumber":commodityNumber
			},
			dataType:'json',
			success:function(result)
			{
				
				$("#productPrice").val(result.stockBean.costPrice);
				$("#unit").val(result.stockBean.unit);
				
			},
			error:function()
	        {
	              alert('系统繁忙');
	        }
		});
	});
	
	
	
	
	/*$("#detailb").click(function(){
		var 
		
		
	});*/
	
	$("#buttono").click(function(){
		$("#CN").removeAttr("readonly");
		$("#PN").removeAttr("readonly");
		$("#PC").removeAttr("readonly");
		$("#BT").removeAttr("readonly");
		$("#OPP").removeAttr("readonly");
		$("#PI").removeAttr("readonly");
		
		$(this).css("display","none");
		$("#ubutton").css("display","inline-block");
		
		
		
	});
	
	$("#ubuttono").click(function(){
		$("#PC").attr("readonly","readonly");
		$("#BT").attr("readonly","readonly");
		$("#OPP").attr("readonly","readonly");
		$("#PI").attr("readonly","readonly");
		
		$(this).css("display","none");
		$("#button").css("display","inline-block");
		
		
		var purchaseId = $("#pid").val();
		var productNum = $("#PC").val();
		var orderPurchaseBusinessTime = $("#BT").val();
		var orderPurchasePerson = $("#OPP").val();
		var purchaseInfo = $("#PI").val();
		
		
		$.ajax({
			type: 'get',
			url: 'purchase/update',
			data:{
				"purchaseId":purchaseId,
				"productNum":productNum,
				"orderPurchaseBusinessTime":orderPurchaseBusinessTime,
				"orderPurchasePerson":orderPurchasePerson,
				"purchaseInfo":purchaseInfo
			},
			dataType:'json',
			success:function(result)
			{
				
				alert(result.success);
			},
			error:function()
	          {
	              alert('系统繁忙');
	          }
			
		});
	});
	 
	
	
	
	
	
	
});






