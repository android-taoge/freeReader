package com.taoge.freereader.bean;

import java.util.List;

/**
 * created by：TangTao on 2018/11/13 16:16
 * <p>
 * email：xxx@163.com
 */
public class OrderState {


    /**
     * order : [{"id":893,"member_id":72,"sn":"wzq20181110133417720000","total_amount":"29.80","status":"0","sub_order":[{"sub_sn":"wzq201811101334177251","sub_total_price":29.8,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":777,"goods_id":110,"goods_name":"蜂蜜柚子茶","thumb":"/Forestproducts/public/uploads/20180604/1f74e05e56f2b27b825f7965ee17267d.jpg","sell_price":"29.80","num":1,"status":0}]}]},{"id":892,"member_id":72,"sn":"wzq20181110133403720000","total_amount":"29.80","status":"0","sub_order":[{"sub_sn":"wzq201811101334037251","sub_total_price":29.8,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":776,"goods_id":110,"goods_name":"蜂蜜柚子茶","thumb":"/Forestproducts/public/uploads/20180604/1f74e05e56f2b27b825f7965ee17267d.jpg","sell_price":"29.80","num":1,"status":0}]}]},{"id":889,"member_id":72,"sn":"wzq20181108112001720000","total_amount":"0.01","status":"0","sub_order":[{"sub_sn":"wzq201811081120017251","sub_total_price":0.01,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":772,"goods_id":136,"goods_name":"test","thumb":"/Forestproducts/public/uploads/20180615/5f4b424f043c3d62815bde3a7cb0011c.jpg","sell_price":"0.01","num":1,"status":0}]}]},{"id":888,"member_id":72,"sn":"wzq20181108111654720000","total_amount":"0.01","status":"0","sub_order":[{"sub_sn":"wzq201811081116547251","sub_total_price":0.01,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":771,"goods_id":136,"goods_name":"test","thumb":"/Forestproducts/public/uploads/20180615/5f4b424f043c3d62815bde3a7cb0011c.jpg","sell_price":"0.01","num":1,"status":0}]}]},{"id":887,"member_id":72,"sn":"wzq20181108111455720000","total_amount":"0.01","status":"1","sub_order":[{"sub_sn":"wzq201811081114557251","sub_total_price":0.01,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":770,"goods_id":136,"goods_name":"test","thumb":"/Forestproducts/public/uploads/20180615/5f4b424f043c3d62815bde3a7cb0011c.jpg","sell_price":"0.01","num":1,"status":1}]}]}]
     * code : 200
     * msg : 查询成功
     */

    private String code;
    private String msg;
    private List<OrderBean> order;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<OrderBean> getOrder() {
        return order;
    }

    public void setOrder(List<OrderBean> order) {
        this.order = order;
    }

    public static class OrderBean {
        /**
         * id : 893
         * member_id : 72
         * sn : wzq20181110133417720000
         * total_amount : 29.80
         * status : 0
         * sub_order : [{"sub_sn":"wzq201811101334177251","sub_total_price":29.8,"user_id":51,"sell_name":"自营","goods":[{"sub_order_id":777,"goods_id":110,"goods_name":"蜂蜜柚子茶","thumb":"/Forestproducts/public/uploads/20180604/1f74e05e56f2b27b825f7965ee17267d.jpg","sell_price":"29.80","num":1,"status":0}]}]
         */

        private int id;
        private int member_id;
        private String sn;
        private String total_amount;
        private String status;
        private List<SubOrderBean> sub_order;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMember_id() {
            return member_id;
        }

        public void setMember_id(int member_id) {
            this.member_id = member_id;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<SubOrderBean> getSub_order() {
            return sub_order;
        }

        public void setSub_order(List<SubOrderBean> sub_order) {
            this.sub_order = sub_order;
        }

        public static class SubOrderBean {
            /**
             * sub_sn : wzq201811101334177251
             * sub_total_price : 29.8
             * user_id : 51
             * sell_name : 自营
             * goods : [{"sub_order_id":777,"goods_id":110,"goods_name":"蜂蜜柚子茶","thumb":"/Forestproducts/public/uploads/20180604/1f74e05e56f2b27b825f7965ee17267d.jpg","sell_price":"29.80","num":1,"status":0}]
             */

            private String sub_sn;
            private double sub_total_price;
            private int user_id;
            private String sell_name;
            private List<GoodsBean> goods;

            public String getSub_sn() {
                return sub_sn;
            }

            public void setSub_sn(String sub_sn) {
                this.sub_sn = sub_sn;
            }

            public double getSub_total_price() {
                return sub_total_price;
            }

            public void setSub_total_price(double sub_total_price) {
                this.sub_total_price = sub_total_price;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getSell_name() {
                return sell_name;
            }

            public void setSell_name(String sell_name) {
                this.sell_name = sell_name;
            }

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class GoodsBean {
                /**
                 * sub_order_id : 777
                 * goods_id : 110
                 * goods_name : 蜂蜜柚子茶
                 * thumb : /Forestproducts/public/uploads/20180604/1f74e05e56f2b27b825f7965ee17267d.jpg
                 * sell_price : 29.80
                 * num : 1
                 * status : 0
                 */

                private int sub_order_id;
                private int goods_id;
                private String goods_name;
                private String thumb;
                private String sell_price;
                private int num;
                private int status;

                public int getSub_order_id() {
                    return sub_order_id;
                }

                public void setSub_order_id(int sub_order_id) {
                    this.sub_order_id = sub_order_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public String getSell_price() {
                    return sell_price;
                }

                public void setSell_price(String sell_price) {
                    this.sell_price = sell_price;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }
            }
        }
    }
}
