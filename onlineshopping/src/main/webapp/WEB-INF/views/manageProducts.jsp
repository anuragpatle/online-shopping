<%@taglib prefix = "sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">

		<c:if test="${not empty message}">
			<div class = "col-xs-12">
				<div class = "alert alert-success alert-dismissible">
					<button type = "button" class = "close"	data-dismiss = "alert">&times;</button>	
					${message}		
				</div>			
			</div>
		</c:if>


		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Project Management</h4>
				</div>

				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" modelAttribute="product" 
					action="${contextRoot}/manage/products" 
					method = "POST"
					enctype = "multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name: </label>
							<div class="col-md-8">
								<sf:input type="text" id="name" path="name" placeHolder="Product Name" class="form-control" /> 
								<sf:errors path = "name" cssClass = "help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Brand Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeHolder="Brand Name" class="form-control" />
								<sf:errors path = "brand" cssClass = "help-block" element="em"/>
							</div>
						</div>
						
						<!-- Description -->
						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description: </label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" id="description" placeHolder="Write a description" class="form-control" />
								<sf:errors path = "description" cssClass = "help-block" element="em"/>
							</div>
						</div>
						
						<!-- Unit Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice" placeHolder="Unit Price In &#8377" class="form-control" />
								<sf:errors path = "unitPrice" cssClass = "help-block" element="em"/>
							</div>
						</div>
						
						<!-- Quantity -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Quantity Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeHolder="Quantity Available" class="form-control" />
								<sf:errors path = "quantity" cssClass = "help-block" element="em"/>
							</div>
						</div>
						
						<!-- Image Select -->
						<div class="form-group">
							<label class="control-label col-md-4">Upload a file</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						
						<!-- Add a new Category -->
						<c:if test="${product.id == 0}">
							<div class="form-group">
								<label class="control-label col-md-4">Category</label>
								<div class="col-md-8">
									<sf:select path="categoryId" items="${categories}" itemLabel="name" itemValue="id" class="form-control"/>
								
									<div class="text-right">
										<br/>			
										<sf:hidden path="id"/>
										<sf:hidden path="code"/>
										<sf:hidden path="supplierId"/>
										<sf:hidden path="active"/>														
										<button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myCategoryModal">Add New Category</button>
									</div>							
								</div>
							
							</div>
						</c:if> 
						
						
						<!-- Submit Btn -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit"
									value="submit" class="btn btn-primary" /> 
							</div>
						</div>
					</sf:form>

				</div>

			</div>


		</div>

	</div>

	<div class="row">

		<div class='col-xs-12'>
			<hr />
			<h1>Available Products</h1>
			<hr />
		</div>

		<div class='col-xs-12'>
		
			<div style = "overflow:auto"></div>
		
			<!-- Products table for adminn -->
			<table id="adminProductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
		
		
		</div>
	
	
	</div>

	<div class="modal fade" id="myCategoryModal" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button> 
					<h4>Add a New Category</h4>
				</div>
				<div class="modal-body" >
					<!-- Form Category -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
						method="POST" class="form-horizontal">
						
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name</label>
							<div class="col-md-8">
								<sf:input type="text" id="category_name" path="name" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="category_description" class="control-label col-md-4">Category Description</label>
							<div class="col-md-8">
								<sf:textarea cols="" rows="5" type="text" path="description" id="category_description" class="form-control"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
												
					</sf:form>
				</div>
			</div>
		</div>	
	</div>

</div>