<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<%@ include file="../../static/head.jsp"%>
	<!-- font-awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>
        .openBox {}

        .openBox .openBG {
            position: fixed;
            width: 100vw;
            height: 100vh;
            background: rgba(0, 0, 0, .3);
            top: 0;
            left: 0;
            z-index: 19;
        }

        .openBox .openView {
            position: fixed;
            width: 80vw;
            height: 60vh;
            background: #fff;
            top: 20vh;
            left: 10vw;
            z-index: 20;
            padding: 20px;
            box-sizing: border-box;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
</style>
<body>
	<div id="main-container">
		<!-- Top Navigation -->
		<%@ include file="../../static/topNav.jsp"%>
				
		<!-- Menu -->
		<div id="menu-container" class="navbar">
			<ul class="navbar-nav navbar-vertical" id="navUl">
				
			</ul>
		</div>
		<!-- /Menu -->

		<!-- Breadcrumb -->
		<div id="breadcrumb-container">
			<h3 class="breadcrumb-title">订单管理</h3>
			<ol class="breadcrumb-list">
				<li class="breadcrumb-item-home">
					<a href="#">
						<span class="ti-home"></span>
					</a>
				</li>
				<li class="breadcrumb-item-one"><span>订单管理</span></li>
				<li class="breadcrumb-item-two"><span>订单列表</span></li>
			</ol>
		</div>
		<!-- /Breadcrumb -->
				
		<!-- Main Content -->
		<div id="center-container">

			<div class="center-form">
				<div class="form-item">
					<label>订单编号</label>
					<input type="text" id="orderidSearch" class="form-control form-control-sm" placeholder="请输入订单编号" aria-controls="tableId">
				</div>
				<div class="form-item">
					<label>商品名称</label>
					<input type="text" id="goodnameSearch" class="form-control form-control-sm" placeholder="请输入商品名称" aria-controls="tableId">
				</div>
				<button onclick="search()" type="button" class="btn btn-search btn-primary">查询</button>
			</div>
			
			<div class="btns">
				<button onclick="add()" type="button" class="btn btn-success btn-add 新增"><i class="fa fa-plus"></i><span>添加</span></button>
				<button onclick="deleteMore()" type="button" class="btn btn-danger btn-del 删除"><i class="fa fa-remove"></i><span>批量删除</span></button>
				<button onclick="exportExcel()" type="button" class="btn btn-success btn-import 导出"><i class="fa fa-file-excel-o"></i><span>导出</span></button>
				<button onclick="chartDialog('1')" type="button" class="btn btn-info btn-graph 日销量"><i class="fa fa-building-o"></i><span>日销量</span></button>
				<button onclick="chartDialog('2')" type="button" class="btn btn-info btn-graph 月销量"><i class="fa fa-building-o"></i><span>月销量</span></button>
				<button onclick="chartDialog('3')" type="button" class="btn btn-info btn-graph 年销量"><i class="fa fa-building-o"></i><span>年销量</span></button>
				<button onclick="chartDialog('4')" type="button" class="btn btn-info btn-graph 品销量"><i class="fa fa-building-o"></i><span>商品销量</span></button>
				<button onclick="chartDialog('5')" type="button" class="btn btn-info btn-graph 类销量"><i class="fa fa-building-o"></i><span>类型销量</span></button>
				<button onclick="chartDialog('6')" type="button" class="btn btn-info btn-graph 日销额"><i class="fa fa-building-o"></i><span>日销额</span></button>
				<button onclick="chartDialog('7')" type="button" class="btn btn-info btn-graph 月销额"><i class="fa fa-building-o"></i><span>月销额</span></button>
				<button onclick="chartDialog('8')" type="button" class="btn btn-info btn-graph 年销额"><i class="fa fa-building-o"></i><span>年销额</span></button>
				<button onclick="chartDialog('9')" type="button" class="btn btn-info btn-graph 品销额"><i class="fa fa-building-o"></i><span>商品销额</span></button>
				<button onclick="chartDialog('10')" type="button" class="btn btn-info btn-graph 类销额"><i class="fa fa-building-o"></i><span>类型销额</span></button>
			</div>

			<table id="tableId" class="table table-bordered">
				<thead>
					<tr>
						<th class="no-sort" style="min-width: 35px;">
							<div class="custom-control custom-checkbox">
								<input class="custom-control-input" type="checkbox" id="select-all" onclick="chooseAll()">
								<label class="custom-control-label" for="select-all"></label>
							</div>
						</th>
						<th onclick="sort('orderid')">订单编号<i id="orderidIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('goodname')">商品名称<i id="goodnameIcon" class="fa fa-sort"></i></th>
						<th>商品图片</th>
						<th onclick="sort('buynumber')">购买数量<i id="buynumberIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('price')">价格<i id="priceIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('discountprice')">折扣价格<i id="discountpriceIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('total')">总价格<i id="totalIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('discounttotal')">折扣总价格<i id="discounttotalIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('type')">支付类型<i id="typeIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('status')">状态<i id="statusIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('address')">地址<i id="addressIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('tel')">电话<i id="telIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('consignee')">收货人<i id="consigneeIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('remark')">备注<i id="remarkIcon" class="fa fa-sort"></i></th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
			

			<div id="pagination">
				<div class="dataTables_length" id="tableId_length">
					<select name="tableId_length" aria-controls="tableId" id="selectPageSize" onchange="changePageSize()">
						<option value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select> 
					<span class="text">条每页</span>
				</div>
				<ul class="pagination">
					<li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
						<a class="page-link" href="#" tabindex="-1">上一页</a>
					</li>
					<li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
						<a class="page-link" href="#">下一页</a>
					</li>
				</ul>
			</div>
            <div class="openBox" v-if="showType">
                <div class="openBG" @click="showClick"></div>
                <div class="openView">
                </div>
            </div>
		</div>
		

	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">Top</a>
	<!-- /Back to Top -->
	
	<%@ include file="../../static/foot.jsp"%>
    <script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/excel/excel-gen.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jszip.min.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/FileSaver.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>

	<script>
		<%@ include file="../../utils/menu.jsp"%>
		<%@ include file="../../static/setMenu.js"%>
		<%@ include file="../../utils/baseUrl.jsp"%>
		<%@ include file="../../static/getRoleButtons.js"%>
		<%@ include file="../../static/crossBtnControl.js"%>
		var orderStatus = getQueryString("orderStatus");
        window.sessionStorage.setItem('orderStatus', orderStatus);
		var tableName = "orders"+"/"+orderStatus;
		var pageType = "list";
	  	var searchForm = { key: ""};
		var pageIndex = 1;
		var pageSize = 10;
		var totalPage = 0;
		var dataList = [];
		var sortColumn = '';
		var sortOrder= '';
		var ids = [];
		var checkAll = false;
        var vm = new Vue({
            el: '#center-container',
            data: {
                showType: false,
            },
            beforeCreate: function() {

            },
            created: function() {},
            methods: {
                showClick() {
                    vm.showType = !vm.showType
                },
            },
        })



		function init() {
			// 满足条件渲染提醒接口
		}
		// 改变每页记录条数
		function changePageSize() {
            pageIndex=1;
		    var selection = document.getElementById('selectPageSize');
		    var index = selection.selectedIndex;
			pageSize = selection.options[index].value;
			getDataList();
        }		
		//排序
		function sort(columnName){
			var iconId = '#'+columnName+'Icon'
			$('th i').attr('class','fa fa-sort');
			if(sortColumn == '' || sortColumn != columnName){
				sortColumn = columnName;
				sortOrder = 'asc';
				$(iconId).attr('class','fa fa-sort-asc');
			}
			if(sortColumn == columnName){
				if(sortOrder == 'asc'){
					sortOrder = 'desc';
					$(iconId).attr('class','fa fa-sort-desc');
				}else{
					sortOrder = 'asc';
					$(iconId).attr('class','fa fa-sort-asc');
				}
			}
			pageIndex = 1;
			getDataList();
		}		
		

		// 查询
		function search(){
			searchForm = { key: ""};
			if($('#orderidSearch').val() != null && $('#orderidSearch').val() != ''){
				searchForm.orderid ="%" +  $('#orderidSearch').val() + "%";
			}
			
			if($('#goodnameSearch').val() != null && $('#goodnameSearch').val() != ''){
				searchForm.goodname ="%" +  $('#goodnameSearch').val() + "%";
			}
			
            pageIndex=1;
			getDataList();
		}		
		// 获取数据列表
        function getDataList() {
			http("orders/page","GET",{
				page: pageIndex,
				limit: pageSize,
				sort: sortColumn,
				order: sortOrder,
				orderid : searchForm.orderid,	
				goodname : searchForm.goodname,	
				status: orderStatus,
			},(res)=>{
				if(res.code == 0){
					clear();
					dataList = res.data.list;
					totalPage = res.data.totalPage;
					//var tbody = document.getElementById('tbMain');
					for(var i = 0;i < dataList.length; i++){ //遍历一下表格数据  
						var trow = setDataRow(dataList[i],i); //定义一个方法,返回tr数据 
						$('tbody').append(trow); 
					}
					pagination(); //渲染翻页组件
					getRoleButtons();// 权限按钮控制
				}
			});
        }		
		// 渲染表格数据
		function setDataRow(item,number){
			//创建行 
			var row = document.createElement('tr'); 
			row.setAttribute('class','useOnce');
			//创建勾选框
			var checkbox = document.createElement('td');
			var checkboxDiv = document.createElement('div');
			checkboxDiv.setAttribute("class","custom-control custom-checkbox");
			var checkboxInput = document.createElement('input');
			checkboxInput.setAttribute("class","custom-control-input");
			checkboxInput.setAttribute("type","checkbox");
			checkboxInput.setAttribute('name','chk');
			checkboxInput.setAttribute('value',item.id);
			checkboxInput.setAttribute("id",number);
			checkboxDiv.appendChild(checkboxInput);
			var checkboxLabel = document.createElement('label');
			checkboxLabel.setAttribute("class","custom-control-label");
			checkboxLabel.setAttribute("for",number);
			checkboxDiv.appendChild(checkboxLabel);
			checkbox.appendChild(checkboxDiv);
			row.appendChild(checkbox)

			var orderidCell  = document.createElement('td');

						 orderidCell.innerHTML = item.orderid;

			row.appendChild(orderidCell);
			var goodnameCell  = document.createElement('td');

						 goodnameCell.innerHTML = item.goodname;

			row.appendChild(goodnameCell);
			var pictureCell  = document.createElement('td');

			            var pictureImg = document.createElement('img');
            pictureImg.setAttribute('src',item.picture?(baseUrl+item.picture.split(",")[0]):'');
			pictureImg.setAttribute('height',100);
			pictureImg.setAttribute('width',100);
			pictureCell.appendChild(pictureImg);


			row.appendChild(pictureCell);
			var buynumberCell  = document.createElement('td');

						 buynumberCell.innerHTML = item.buynumber;

			row.appendChild(buynumberCell);
			var priceCell  = document.createElement('td');

						 priceCell.innerHTML = item.price;

			row.appendChild(priceCell);
			var discountpriceCell  = document.createElement('td');

						 discountpriceCell.innerHTML = item.discountprice;

			row.appendChild(discountpriceCell);
			var totalCell  = document.createElement('td');

						 totalCell.innerHTML = item.total;

			row.appendChild(totalCell);
			var discounttotalCell  = document.createElement('td');

						 discounttotalCell.innerHTML = item.discounttotal;

			row.appendChild(discounttotalCell);
			var typeCell  = document.createElement('td');

						 typeCell.innerHTML = item.type;

			row.appendChild(typeCell);
			var statusCell  = document.createElement('td');

						 statusCell.innerHTML = item.status;

			row.appendChild(statusCell);
			var addressCell  = document.createElement('td');

						 addressCell.innerHTML = item.address;

			row.appendChild(addressCell);
			var telCell  = document.createElement('td');

						 telCell.innerHTML = item.tel;

			row.appendChild(telCell);
			var consigneeCell  = document.createElement('td');

						 consigneeCell.innerHTML = item.consignee;

			row.appendChild(consigneeCell);
			var remarkCell  = document.createElement('td');

						 remarkCell.innerHTML = item.remark;

			row.appendChild(remarkCell);
			var logisticsCell  = document.createElement('td');

			

			//每行按钮
			var btnGroup = document.createElement('td');


			//详情按钮
			var detailBtn = document.createElement('button');
			var detailAttr = "detail(" + item.id + ')';
			detailBtn.setAttribute("type","button");
			detailBtn.setAttribute("class","btn btn-info btn-sm 查看");
			detailBtn.setAttribute("onclick",detailAttr);
			detailBtn.innerHTML = "查看"
			btnGroup.appendChild(detailBtn)
			//修改按钮
			var editBtn = document.createElement('button');
			var editAttr = 'edit(' +  item.id + ')';
			editBtn.setAttribute("type","button");
			editBtn.setAttribute("class","btn btn-warning btn-sm 修改");
			editBtn.setAttribute("onclick",editAttr);
			editBtn.innerHTML = "修改"
			btnGroup.appendChild(editBtn)

			if(orderStatus=="已支付") {
				//发货按钮
				var sendBtn = document.createElement('button');
				var sendAttr = 'sendGood(' +  item.id + ')';
				sendBtn.setAttribute("type","button");
				sendBtn.setAttribute("class","btn btn-warning btn-sm 发货");
				sendBtn.setAttribute("onclick",sendAttr);
				sendBtn.innerHTML = "发货";
				btnGroup.appendChild(sendBtn);
			}
			if(orderStatus=="已发货") {
				//确认收获按钮
				var confirmBtn = document.createElement('button');
				var confirmAttr = 'orderConfirm(' +  item.id + ')';
				confirmBtn.setAttribute("type","button");
				confirmBtn.setAttribute("class","btn btn-warning btn-sm 确认收货");
				confirmBtn.setAttribute("onclick",confirmAttr);
				confirmBtn.innerHTML = "确认收货";
				btnGroup.appendChild(confirmBtn);
			}
            //物流
            var logisticsBtn = document.createElement('button');
            var logisticsAttr = 'logisticsUpdate(' +  item.id + ')';
            logisticsBtn.setAttribute("type","button");
            logisticsBtn.setAttribute("class","btn btn-warning btn-sm 物流");
            logisticsBtn.setAttribute("onclick",logisticsAttr);
            logisticsBtn.innerHTML = "物流";
            btnGroup.appendChild(logisticsBtn);
			//删除按钮
			var deleteBtn = document.createElement('button');
			var deleteAttr = 'remove(' +  item.id + ')';
			deleteBtn.setAttribute("type","button");
			deleteBtn.setAttribute("class","btn btn-danger btn-sm 删除");
			deleteBtn.setAttribute("onclick",deleteAttr);
			deleteBtn.innerHTML = "删除"
			btnGroup.appendChild(deleteBtn)


			row.appendChild(btnGroup)
			return row;
		}		
	// 导出
        function exportExcel() { 
        	excel = new ExcelGen({
                "src_id": "tableId",
                "show_header": true
            });
        excel.generate();
        }


		// 翻页
        function pageNumChange(val) {
            if(val == 'pre') {
                pageIndex--;
            }else if(val == 'next'){
                pageIndex++;
            }else{
                pageIndex = val;
            }
			getDataList();
        }		
		// 下载
		function download(url){
			window.open(url);
		}
		// 打开新窗口播放媒体
		function mediaPlay(url){
			window.open(url);
		}		
		// 渲染翻页组件
		function pagination() {
			var beginIndex = pageIndex;
			var endIndex = pageIndex;
			var point = 4;
            if(totalPage!=0) {
                //计算页码
                for(var i=0;i<3;i++){
                    if(endIndex==totalPage){ break;}
                    endIndex++;
                    point--;
                }
                for(var i=0;i<3;i++){
                    if(beginIndex==1){break;}
                    beginIndex--;
                    point--;
                }
                if(point>0){
                    while (point>0){
                        if(endIndex==totalPage){ break;}
                        endIndex++;
                        point--;
                    }
                    while (point>0){
                        if(beginIndex==1){ break;}
                        beginIndex--;
                        point--
                    }
                }
            }
			// 是否显示 前一页 按钮
			if(pageIndex>1){
				$('#tableId_previous').show();
			}else{
				$('#tableId_previous').hide();
			}
			// 渲染页码按钮
			for(var i=beginIndex;i<=endIndex;i++){
				var pageNum = document.createElement('li');
				pageNum.setAttribute('onclick',"pageNumChange("+i+")");
				if(pageIndex == i){
					pageNum.setAttribute('class','paginate_button page-item active useOnce');
				}else{
					pageNum.setAttribute('class','paginate_button page-item useOnce');
				}								
				var pageHref = document.createElement('a');
				pageHref.setAttribute('class','page-link');
				pageHref.setAttribute('href','#');
				pageHref.setAttribute('aria-controls','tableId');
				pageHref.setAttribute('data-dt-idx',i);
				pageHref.setAttribute('tabindex',0);
				pageHref.innerHTML = i;
				pageNum.appendChild(pageHref);
				$('#tableId_next').before(pageNum);
			}
			// 是否显示 下一页 按钮
			if(pageIndex < totalPage){
				$('#tableId_next').show();
				$('#tableId_next a').attr('data-dt-idx',endIndex+1);
			}else{
				$('#tableId_next').hide();
			}
			var pageNumInfo = "当前第 "+ pageIndex + " 页，共 "+ totalPage + " 页";
			$('#tableId_info').html(pageNumInfo);
		}		
		// 跳转到指定页
		function toThatPage(){
			//var index = document.getElementById('pageIndexInput').value;
			if(index<0 || index>totalPage){
				alert('请输入正确的页码');
			}else {
				pageNumChange(index);
			}
		}		
		// 全选/全不选
		function chooseAll(){
			checkAll = !checkAll;
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				boxs[i].checked= checkAll;
			}
		}		
	
		// 批量删除
		function deleteMore(){
			ids = []
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				if(boxs[i].checked){
					ids.push(boxs[i].value)
				}
			}
			if(ids.length == 0){
				alert('请勾选要删除的记录');
			}else{
				remove(ids);
			}
		}	
		// 删除
        function remove(id) { 
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
				var paramArray = [];
				if (id == ids){
					paramArray = id;
				}else{
					paramArray.push(id);
				}             
				httpJson("orders/delete","POST",paramArray,(res)=>{
					if(res.code == 0){
						getDataList();		
						alert('删除成功');
					}
				});         
            }
            else {
                alert("已取消操作");
            }
        }			
		// 用户登出
        <%@ include file="../../static/logout.jsp"%>

		//修改
        function edit(id) {
            window.sessionStorage.setItem('id', id)
            window.location.href = "add-or-update.jsp"
        }
		//清除会重复渲染的节点
        function clear(){
        	var elements = document.getElementsByClassName('useOnce');
        	for(var i = elements.length - 1; i >= 0; i--) { 
        	  elements[i].parentNode.removeChild(elements[i]); 
        	}
        }
	//添加
	function add(){
		window.location.href = "add-or-update.jsp"
	}
	//单列求和
	function getSum(colName){
		http("orders"+colName,"GET",{
			tableName: "orders",
			columnName: colName
		},(res)=>{
			if(res.code == 0){
				return res.data.sum;
			}
		});
	}		
	// 查看详情
	function detail(id){
		window.sessionStorage.setItem("id", id);
		//window.sessionStorage.setItem("ifView", true);
		window.location.href = "info.jsp";
	}

	//跨表
	function crossTable(obj,crossTableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
		window.sessionStorage.setItem('crossTableId',obj.id);
		window.sessionStorage.setItem('crossObj', JSON.stringify(obj));
		window.sessionStorage.setItem('crossTableName',"orders");
		window.sessionStorage.setItem('statusColumnName',statusColumnName);
		window.sessionStorage.setItem('statusColumnValue',statusColumnValue);
		window.sessionStorage.setItem('tips',tips);
		if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
			for (var o in obj){
				if(o==statusColumnName && obj[o]==statusColumnValue){
                    alert(tips);
					return
				}
			}
		}
		var url = "../"+crossTableName+"/add-or-update.jsp?cross=true";
		window.location.href = url;
	}

        //跳转到支付页面
        function pay(item){
            window.sessionStorage.setItem('oId',item.id);
			window.sessionStorage.setItem('tableName',"orders");
            window.location.href = "${pageContext.request.contextPath}/jsp/pay.jsp";
        }

                function chartDialog(type){
                    window.open('graph.jsp?type='+type);
                }






	function getQueryString(name) {
        	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        	var param = window.location.search;
        	var r = decodeURI(param).substr(1).match(reg);      
        	if (r != null) return unescape(r[2]);
        	return null;
	}

        // 发货
        function sendGood(id) {
            var mymessage = confirm("确认发货吗？");
            if (mymessage == true) {
                 http("orders/info/" + id,"GET",{},(res)=>{
                        res.data.status = "已发货";
                        let data= res.data;
                        httpJson("orders/update","POST",data,(res)=>{
                                if(res.code == 0){
                                        getDataList();
                                        alert('发货成功');
                                }
                        });
                });
            }
        }
        // 确认收货
        function orderConfirm(id) {
            var mymessage = confirm("确认已收货？");
            if (mymessage == true) {
                 http("orders/info/" + id,"GET",{},(res)=>{
                        res.data.status = "已完成";
                        let data= res.data;
                        httpJson("orders/update","POST",data,(res)=>{
                                if(res.code == 0){
                                        getDataList();
                                        alert('操作成功');
                                }
                        });
                });
            }
        }	
        //物流
        function logisticsUpdate(id) {
            window.sessionStorage.setItem('id', id)
            window.location.href = "add-or-update.jsp?type=logistics"
        }


		$(document).ready(function() { 
			//激活翻页按钮
			$('#tableId_previous').attr('class','paginate_button page-item previous')
			$('#tableId_next').attr('class','paginate_button page-item next')
			//隐藏原生搜索框
			$('#tableId_filter').hide()
			//设置右上角用户名
			$('.dropdown-menu h5').html(window.sessionStorage.getItem('username')+'('+window.sessionStorage.getItem('role')+')')
			//设置项目名
			$('.sidebar-header h3 a').html(projectName)
			setMenu();			
			init();
			getDataList();
			<%@ include file="../../static/myInfo.js"%>
		});
	</script>
</body>

</html>
