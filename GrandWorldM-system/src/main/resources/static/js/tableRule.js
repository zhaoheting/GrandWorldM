    var vue = new Vue({
        el:'#ruleDiv',
        data:{
            tableRuleList: []
        },
    //    mounted(){
    //        axios
    //            .get('http://localhost:8080/rule/table')
    //            .then(response=> (this.tableRuleList= response.tableRuleList))
    //            .catch(function (error) {
    //                    console.log(error);
    //            });
    //    },
        methods:{
            getTableRuleList:function(){
                //发送get请求
                this.$http.get('http://localhost:8080/rule/table').then(function(result){
                      tableRuleList= result;
                },function(){
                    console.log('请求失败处理');
                });
            }
        }
    });


//function getTableRuleList(){
//    $.ajax({
//        url: "http://localhost:8080/rule/table",
//        dataType: "json",
//        type: "GET",
//        success: function(result){
//            vue.tableRuleList: result;
//        }
//    });
//}
//
//$(function(){
//    getTableRuleList();
//})
