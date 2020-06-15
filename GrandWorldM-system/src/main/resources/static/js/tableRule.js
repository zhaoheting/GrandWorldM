    // unblock when ajax activity stops
    $(document).ajaxStop($.unblockUI);
    $(function(){
    alert('test');
        var vue = new Vue({
            el:'#ruleDiv',
            data:{
                tenantKey: "",
                bundleName: "",
                ruleName: "",
                tableRuleList: []
            },
            methods:{
                getTableRuleList:function(){
                    $.blockUI();
                    $.ajax({
                        url: "http://localhost:8080/rule/table",
                        dataType: "json",
                        type: "GET",
                        success: function(result){
                            vue.tableRuleList= result;
                        }
                    });
                }
            }
        });
    })

