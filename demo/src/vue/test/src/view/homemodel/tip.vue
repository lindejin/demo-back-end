<template>
    <div class=''>
        <!--菜单 -->
        <div class=tip>
            <div id="sidebar">
                <div id="wrap">
                    <div id="prof" class="item ">
                        <a href="# ">
                            <span class="setting "></span>
                        </a>
                        <div class="ibar_login_box status_login ">
                            <div class="avatar_box ">
                                <p class="avatar_imgbox "><img :src="require('../../../static/style/images/no-img_mid_.jpg')" /></p>
                                <ul class="user_info ">
                                    <li>用户名sl1903</li>
                                    <li>级&nbsp;别普通会员</li>
                                </ul>
                            </div>
                            <div class="login_btnbox ">
                                <a href="# " class="login_order ">我的订单</a>
                                <a href="# " class="login_favorite ">我的收藏</a>
                            </div>
                            <i class="icon_arrow_white "></i>
                        </div>

                    </div>
                    <div id="shopCart " class="item ">
                        <a href="# ">
                            <span class="message "></span>
                        </a>
                        <p>
                            购物车
                        </p>
                        <p class="cart_num ">0</p>
                    </div>
                    <div id="asset " class="item ">
                        <a href="# ">
                            <span class="view "></span>
                        </a>
                        <div class="mp_tooltip ">
                            我的资产
                            <i class="icon_arrow_right_black "></i>
                        </div>
                    </div>

                    <div id="foot " class="item ">
                        <a href="# ">
                            <span class="zuji "></span>
                        </a>
                        <div class="mp_tooltip ">
                            我的足迹
                            <i class="icon_arrow_right_black "></i>
                        </div>
                    </div>

                    <div id="brand " class="item ">
                        <a href="#">
                            <span class="wdsc "><img :src="require('../../../static/style/images/wdsc.png')" /></span>
                        </a>
                        <div class="mp_tooltip ">
                            我的收藏
                            <i class="icon_arrow_right_black "></i>
                        </div>
                    </div>

                    <div id="broadcast " class="item ">
                        <a href="# ">
                            <span class="chongzhi "><img :src="require('../../../static/style/images/chongzhi.png')" /></span>
                        </a>
                        <div class="mp_tooltip ">
                            我要充值
                            <i class="icon_arrow_right_black "></i>
                        </div>
                    </div>

                    <div class="quick_toggle ">
                        <li class="qtitem ">
                            <a href="# "><span class="kfzx "></span></a>
                            <div class="mp_tooltip ">客服中心<i class="icon_arrow_right_black "></i></div>
                        </li>
                        <!--二维码 -->
                        <li class="qtitem ">
                            <a href="#none "><span class="mpbtn_qrcode "></span></a>
                            <div class="mp_qrcode " style="display:none; "><img :src="require('../../../static/style/images/weixin_code_145.png')" /><i
                                    class="icon_arrow_white "></i></div>
                        </li>
                        <li class="qtitem ">
                            <a href="#top " class="return_top "><span class="top "></span></a>
                        </li>
                    </div>

                    <!--回到顶部 -->
                    <div id="quick_links_pop " class="quick_links_pop hide "></div>

                </div>

            </div>
            <div id="prof-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    我
                </div>
            </div>
            <div id="shopCart-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    购物车
                </div>
            </div>
            <div id="asset-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    资产
                </div>

                <div class="ia-head-list ">
                    <a href="# " target="_blank " class="pl ">
                        <div class="num ">0</div>
                        <div class="text ">优惠券</div>
                    </a>
                    <a href="# " target="_blank " class="pl ">
                        <div class="num ">0</div>
                        <div class="text ">红包</div>
                    </a>
                    <a href="# " target="_blank " class="pl money ">
                        <div class="num ">￥0</div>
                        <div class="text ">余额</div>
                    </a>
                </div>

            </div>
            <div id="foot-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    足迹
                </div>
            </div>
            <div id="brand-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    收藏
                </div>
            </div>
            <div id="broadcast-content " class="nav-content ">
                <div class="nav-con-close ">
                    <i class="am-icon-angle-right am-icon-fw "></i>
                </div>
                <div>
                    充值
                </div>
            </div>
        </div>

    </div>
</template>
<script>
// 这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
// 例如：import 《组件名称》 from '《组件路径》';
export default {
  components: {}, // import引入的组件需要注入到components中才能使用
  data () {
    return {
    }
  },
  // 监听属性 类似于data概念
  computed: {},
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {},
  created () { }, // 生命周期 - 创建完成（可以访问当前this实例）
  mounted () { }, // 生命周期 - 挂载完成（可以访问DOM元素）
  beforeCreate () { }, // 生命周期 - 创建之前
  beforeMount () { }, // 生命周期 - 挂载之前
  beforeUpdate () { }, // 生命周期 - 更新之前
  updated () { }, // 生命周期 - 更新之后
  beforeDestroy () { }, // 生命周期 - 销毁之前
  destroyed () { }, // 生命周期 - 销毁完成
  activated () { } // 如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style  scoped>
@import "../../../static/style/AmazeUI-2.4.2/assets/css/amazeui.css";
@import "../../../static/style/AmazeUI-2.4.2/assets/css/admin.css";
@import "../../../static/style/basic/css/demo.css";
@import "../../../static/style/css/hmstyle.css";
@import "../../../static/style/css/skin.css";
</style>
