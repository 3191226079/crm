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
	
	
	$("#ubut").click(function(){
			
			$(this).css("display","none");
			$("#but").css("display","inline-block");
			$("#supplierName").removeAttr("readonly");
			$("#supplierContact").removeAttr("readonly");
			$("#supplierPhone").removeAttr("readonly");
			$("#supplierFax").removeAttr("readonly");
			$("#supplierEmail").removeAttr("readonly");
			$("#supplierInfo").removeAttr("readonly");	
	});
	
	$("#but").click(function(){
		$(this).css("display","none");
		$("#ubut").css("display","inline-block");
		$("#supplierName").attr("readonly");
		$("#supplierContact").attr("readonly");
		$("#supplierPhone").attr("readonly");
		$("#supplierFax").attr("readonly");
		$("#supplierEmail").attr("readonly");
		$("#supplierInfo").attr("readonly");	
		
		var supplierId = $("#supplierId").val();
		var supplierName = $("#supplierName").val();
		var supplierContact = $("#supplierContact").val();
		var supplierPhone = $("#supplierPhone").val();
		var supplierFax = $("#supplierFax").val();
		var supplierEmail = $("#supplierEmail").val();
		var supplierInfo = $("#supplierInfo").val();
		
		
		$.ajax({
			type: 'get',
			url: 'supplier/update',
			data:{
				"supplierId":supplierId,
				"supplierName":supplierName,
				"supplierContact":supplierContact,
				"supplierPhone":supplierPhone,
				"supplierFax":supplierFax,
				"supplierEmail":supplierEmail,
				"supplierInfo":supplierInfo
			},
			dataType:'json',
			success:function(result)
			{
				
				alert(result.msg);
			},
			error:function()
	          {
	              alert('系统繁忙');
	          }
			
		});
	});
	
	
	
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
		var supplierId = $("#supid").val();
		
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
	          error:function()
		      {
		              alert('系统繁忙');
		      }
	          

	      });
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
var count = 1;
var sumMoney= 0;
var detailPurchaseList = [];
	$("#detailb").click(function(){
		var productId =  $("#sed").val();
		var productNum = $("#productNum").val();
		var productPrice = $("#productPrice").val();
		var unit = $("#unit").val();
		var detailPurchaseInfo = $("#detailPurchaseInfo").val();
		var detailPurchasePerson = $("#detailPurchasePerson").val();
		var orderPurchaseId = $("#opid").val();
		sumMoney = sumMoney+(productPrice*productNum);
		$("#box_r").css("display","none");
		$("#box_r").css("position","relative");
		$("#orderPurchaseMoney").val(sumMoney);
		$("#orderPurchaseState").val("未付款");
		
		var commodityName = $("#sed  option:selected").text();
		var msg = "未入库";
		var tr = '<tr><td>'+count+'</td><td>'+commodityName+'</td><td>'+productId+'</td><td>'+productNum+'</td><td>'+productPrice+'</td><td>'+unit+'</td><td>'+productNum*productPrice+'</td><td>'+msg+'</td></tr>'   
		$('#tabr').append($(tr));
		count = count + 1;
		var detailPurchaseId = null;
		var detailPurchaseState = null;
		
		//采购单明细信息
		var data = {
				"productId":productId,
				"productNum":productNum,
				"productPrice":productPrice,
				"detailPurchaseInfo":detailPurchaseInfo,
				"detailPurchasePerson":detailPurchasePerson,
					
			};
		detailPurchaseList.push(data);
				
		
		
		
		
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
		
		
		
		//采购单信息
		var data ={
				orderPurchaseTitle:orderPurchaseTitle,
				orderPurchaseTime:orderPurchaseTime,
				supplierId:supplierId,
				orderPurchaseMoney:orderPurchaseMoney,
				orderPurchaseInfo:orderPurchaseInfo,
				orderPurchaseBusinessTime:orderPurchaseBusinessTime,
				orderPurchaseBusinessType:orderPurchaseBusinessType,
				orderPurchaseBusinessAddress:orderPurchaseBusinessAddress,
				orderPurchasePerson:orderPurchasePerson,
				detailPurchaseList:detailPurchaseList
		};
		
	var orderPurchaseBean =JSON.stringify(data);
		$.ajax({
			type:'post',
			url:'purchaseOrder/add',
			data:orderPurchaseBean,
			headers:{'Accept':'application/json','Content-Type':'application/json;charset=utf-8'},
			dataType:'json',
			success:function(result)
			{
				alert(result.success);
			},
			error:function()
	        {
	              alert('系统繁忙');
	        }
			
			
		})
		
		
	});
	
	$("#yes_ra").click(function(){
		var orderPurchaseId = $("#id").val();
		console.log(orderPurchaseId);
		 $.ajax({
	          type: 'get',
	          url:'purchaseOrder/del',
	          data: {"orderPurchaseId":orderPurchaseId},
	          dataType: 'json',
	          success:function (result)
	          {
        	  location.href = "http://localhost:8080/crmsys/purchaseOrder/select";
	        	  alert(result.msg);
	          },
	          error:function()
		      {
		              alert('系统繁忙');
		      }

	      });
	});
	
	
	
	
	
	
	
});






