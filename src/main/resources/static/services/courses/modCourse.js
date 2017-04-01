app.controller("addCourses", function($scope, $http, $location) {
				$scope.course = {};
                idC = $location.search().idCourse;
                if(idC == undefined)
                    {
                        window.location = "/"
                    }
				
				$("#cover").change(function(){
					console.log(this)
					file = new FileReader();
					
					if( document.getElementById('cover').files[0] )
					{
						file.addEventListener("load", function(e){
							
							$("#preview").attr('src', e.target.result)
							
						});
						file.readAsDataURL(document.getElementById('cover').files[0]);
					}
						
				})
				
				
				$scope.addcours = function() {
					
					if(!$scope.courseForm.$valid)
					{
						$scope.dialog.title = $scope.dialog.ok.title;
						$scope.dialog.content = $scope.dialog.ok.content;
						$("#confirmationModal").modal("show");
						return;
					}
						
					
					file = new FileReader();
					//$scope.course.image = "";
					
					if( document.getElementById('cover').files[0] ){
						file.addEventListener("load", function(e) {
							img_b64 = e.target.result
							$scope.course.image = img_b64;
							console.log( $scope.course.image )
							$http.post("/resources/courses", $scope.course)
							.then(function() {
								window.location = "/services/profil.html";
							});
							
						});
						file.readAsDataURL(document.getElementById('cover').files[0]);
					}else{
						$http.post("/resources/courses", $scope.course)
						.then(function() {
							window.location = "/services/profil.html";
							//console.log("ajouter avec succes");
						});
					}
		
				}
                
                $http.get("/resources/courses/"+idC)
                    .then(function(result){
                    $scope.course.image = result.data.image;
                    $scope.course.subject = result.data.subject;
                    $scope.couse.description = result.data.description;
                })
                
				
			});