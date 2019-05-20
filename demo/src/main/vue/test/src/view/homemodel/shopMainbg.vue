<template>
    <div class=''>
        <div class="shopMainbg">
            <div class="shopMain" id="shopmain">

                <!--热门活动 -->

                <div class="am-container">

                    <div class="sale-mt">
                        <i></i>
                        <em class="sale-title">限时秒杀</em>
                        <div class="s-time" id="countdown">
                            <span class="hh">{{ seckillsHours }}</span>
                            <span class="mm">{{ seckillsMinutes }}</span>
                            <span class="ss">{{ seckillsSeconds }}</span>
                        </div>
                    </div>

                    <div class="am-g am-g-fixed sale">
                        <div class="am-u-sm-3 sale-item">
                            <div class="s-img">
                                <a href="# "><img :src="require('../../../static/style/images/sale3.jpg')" /></a>
                            </div>
                            <div class="s-info">
                                <a href="#">
                                    <p class="s-title">ZEK 原味海苔</p>
                                </a>
                                <div class="s-price">￥<b>9.90</b>
                                    <a class="s-buy" href="#">秒杀</a>
                                </div>
                            </div>
                        </div>

                        <div class="am-u-sm-3 sale-item">
                            <div class="s-img">
                                <a href="# "><img :src="require('../../../static/style/images/sale2.jpg')" /></a>
                            </div>
                            <div class="s-info">
                                <a href="#">
                                    <p class="s-title">ZEK 原味海苔</p>
                                </a>
                                <div class="s-price">￥<b>9.90</b>
                                    <a class="s-buy" href="#">秒杀</a>
                                </div>
                            </div>
                        </div>

                        <div class="am-u-sm-3 sale-item">
                            <div class="s-img">
                                <a href="# "><img :src="require('../../../static/style/images/sale1.jpg')" /></a>
                            </div>
                            <div class="s-info">
                                <a href="#">
                                    <p class="s-title">ZEK 原味海苔</p>
                                </a>
                                <div class="s-price">￥<b>9.90</b>
                                    <a class="s-buy" href="#">秒杀</a>
                                </div>
                            </div>
                        </div>

                        <div class="am-u-sm-3 sale-item">
                            <div class="s-img">
                                <a href="# "><img :src="require('../../../static/style/images/sale2.jpg')" /></a>
                            </div>
                            <div class="s-info">
                                <a href="#">
                                    <p class="s-title">ZEK 原味海苔</p>
                                </a>
                                <div class="s-price">￥<b>9.90</b>
                                    <a class="s-buy" href="#">秒杀</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="clear "></div>
                <div class="f1">
                    <!--甜点-->

                    <div class="am-container ">
                        <div class="shopTitle ">
                            <h4 class="floor-title">甜品</h4>
                            <div class="floor-subtitle"><em class="am-icon-caret-left"></em>
                                <h3>每一道甜品都有一个故事</h3>
                            </div>
                            <div class="today-brands " style="right:0px ;top:13px;">
                                <!-- <a href="# ">桂花糕</a>|
                                <a href="# ">奶皮酥</a>|
                                <a href="# ">栗子糕 </a>|
                                <a href="# ">马卡龙</a>|
                                <a href="# ">铜锣烧</a>| -->
                                <a href="# ">豌豆黄</a>
                            </div>

                        </div>
                    </div>

                    <div class="am-g am-g-fixed floodSix ">
                        <div class="am-u-sm-5 am-u-md-3 text-one list">
                            <div class="word">
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <!-- <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a> -->
                            </div>
                            <a href="# ">

                                <div class="outer-con ">
                                    <div class="title ">
                                        零食大礼包开抢啦
                                    </div>

                                </div>

                            </a>
                            <div class="triangle-topright"></div>
                        </div>

                        <div class="am-u-sm-7 am-u-md-5 am-u-lg-2 text-two big">

                            <div class="outer-con ">
                                <div class="title ">
                                    广东贵妃荔枝
                                </div>
                                <div class="sub-title ">
                                    ¥13.8
                                </div>

                            </div>
                            <a href="# "><img :src="require('../../../static/style/images/act1.png')" /></a>
                        </div>

                        <li>
                            <div class="am-u-md-2 am-u-lg-2 text-three">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/1.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-md-2 am-u-lg-2 text-three sug">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/2.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-5 am-u-lg-4 text-five">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/5.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-2 am-u-lg-2 text-six">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/3.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-2 am-u-lg-4 text-six">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/4.jpg')" /></a>
                            </div>
                        </li>
                    </div>

                    <div class="clear "></div>
                </div>
                <div class="f2">

                    <!--坚果-->
                    <div class="am-container ">
                        <div class="shopTitle ">
                            <h4 class="floor-title">坚果</h4>
                            <div class="floor-subtitle"><em class="am-icon-caret-left"></em>
                                <h3>酥酥脆脆，回味无穷</h3>
                            </div>
                            <div class="today-brands " style="right:0px ;top:13px">
                                <a href="# ">腰果</a>|
                                <!-- <a href="# ">松子</a>|
                                <a href="# ">夏威夷果 </a>|
                                <a href="# ">碧根果</a>|
                                <a href="# ">开心果</a>|
                                <a href="# ">核桃仁</a> -->
                            </div>
                        </div>
                    </div>
                    <div class="am-g am-g-fixed floodSeven">
                        <div class="am-u-sm-5 am-u-md-4 text-one list ">
                            <div class="word">
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <!-- <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a> -->
                            </div>
                            <a href="# ">
                                <div class="outer-con ">
                                    <div class="title ">
                                        零食大礼包开抢啦！
                                    </div>

                                </div>
                                <!-- <img :src="require('../../../static/style/images/11.jpg')" /> -->
                            </a>
                            <div class="triangle-topright"></div>
                        </div>

                        <div class="am-u-sm-7 am-u-md-4 text-two big">

                            <div class="outer-con ">
                                <div class="title ">
                                    广东贵妃荔枝
                                </div>
                                <div class="sub-title ">
                                    ¥13.8
                                </div>

                            </div>
                            <a href="# "><img :src="require('../../../static/style/images/act2.png')" /></a>

                        </div>

                        <li>
                            <div class="am-u-sm-7 am-u-md-4 text-two">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        广东贵妃荔枝
                                    </div>
                                    <div class="sub-title ">
                                        ¥13.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/6.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three sug">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/7.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three big">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/10.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three ">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/8.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three ">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/9.jpg')" /></a>
                            </div>
                        </li>
                    </div>
                    <div class="clear "></div>
                </div>

                <div class="f3">
                    <!--甜点-->

                    <div class="am-container ">
                        <div class="shopTitle ">
                            <h4 class="floor-title">甜品</h4>
                            <div class="floor-subtitle"><em class="am-icon-caret-left"></em>
                                <h3>每一道甜品都有一个故事</h3>
                            </div>
                            <div class="today-brands " style="right:0px ;top:13px;">
                                <a href="# ">桂花糕</a>|
                                <!-- <a href="# ">奶皮酥</a>|
                                <a href="# ">栗子糕 </a>|
                                <a href="# ">马卡龙</a>|
                                <a href="# ">铜锣烧</a>|
                                <a href="# ">豌豆黄</a> -->
                            </div>

                        </div>
                    </div>

                    <div class="am-g am-g-fixed floodSix ">

                        <div class="am-u-sm-5 am-u-md-3 text-one list">
                            <div class="word">
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <!-- <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a> -->
                            </div>
                            <a href="# ">
                                <!-- <img :src="require('../../../static/style/images/5.jpg')" /> -->
                                <div class="outer-con ">
                                    <div class="title ">
                                        零食大礼包开抢啦
                                    </div>
                                </div>
                            </a>
                            <div class="triangle-topright"></div>
                        </div>

                        <div class="am-u-sm-7 am-u-md-5 am-u-lg-2 text-two big">

                            <div class="outer-con ">
                                <div class="title ">
                                    广东贵妃荔枝
                                </div>
                                <div class="sub-title ">
                                    ¥13.8
                                </div>

                            </div>
                            <a href="# "><img :src="require('../../../static/style/images/act1.png')" /></a>
                        </div>

                        <li>
                            <div class="am-u-md-2 am-u-lg-2 text-three">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/1.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-md-2 am-u-lg-2 text-three sug">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/2.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-5 am-u-lg-4 text-five">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/5.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-2 am-u-lg-2 text-six">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/3.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-4 am-u-md-2 am-u-lg-4 text-six">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/4.jpg')" /></a>
                            </div>
                        </li>
                    </div>
                    <div class="clear "></div>
                </div>
                <div class="f4">

                    <!--坚果-->
                    <div class="am-container ">
                        <div class="shopTitle ">
                            <h4 class="floor-title">坚果</h4>
                            <div class="floor-subtitle"><em class="am-icon-caret-left"></em>
                                <h3>酥酥脆脆，回味无穷</h3>
                            </div>
                            <div class="today-brands " style="right:0px ;top:13px">
                                <a href="# ">腰果</a>|
                                <!-- <a href="# ">松子</a>|
                                <a href="# ">夏威夷果 </a>|
                                <a href="# ">碧根果</a>|
                                <a href="# ">开心果</a>|
                                <a href="# ">核桃仁</a> -->
                            </div>
                        </div>
                    </div>
                    <div class="am-g am-g-fixed floodSeven">
                        <div class="am-u-sm-5 am-u-md-4 text-one list ">
                            <div class="word">
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <!-- <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a>
                                <a class="outer" href="#"><span class="inner"><b class="text">核桃</b></span></a> -->
                            </div>
                            <a href="# ">
                                <div class="outer-con ">
                                    <div class="title ">
                                        零食大礼包开抢啦！
                                    </div>

                                </div>
                                <!-- <img :src="require('../../../static/style/images/11.jpg')" /> -->
                            </a>
                            <div class="triangle-topright"></div>
                        </div>

                        <div class="am-u-sm-7 am-u-md-4 text-two big">

                            <div class="outer-con ">
                                <div class="title ">
                                    广东贵妃荔枝
                                </div>
                                <div class="sub-title ">
                                    ¥13.8
                                </div>

                            </div>
                            <a href="# "><img :src="require('../../../static/style/images/act2.png')" /></a>

                        </div>

                        <li>
                            <div class="am-u-sm-7 am-u-md-4 text-two">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        广东贵妃荔枝
                                    </div>
                                    <div class="sub-title ">
                                        ¥13.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/6.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three sug">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/7.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three big">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/10.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three ">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/8.jpg')" /></a>
                            </div>
                        </li>
                        <li>
                            <div class="am-u-sm-3 am-u-md-2 text-three ">
                                <div class="boxLi"></div>
                                <div class="outer-con ">
                                    <div class="title ">
                                        新疆哈密瓜
                                    </div>
                                    <div class="sub-title ">
                                        ¥4.8
                                    </div>

                                </div>
                                <a href="# "><img :src="require('../../../static/style/images/9.jpg')" /></a>
                            </div>
                        </li>
                    </div>
                    <div class="clear "></div>
                </div>
                <div class="footer ">
                    <div class="footer-hd ">
                        <p>
                            <a href="# ">工程科技</a>
                            <b>|</b>
                            <a href="# ">商城首页</a>
                            <b>|</b>
                            <a href="# ">支付宝</a>
                            <b>|</b>
                            <a href="# ">物流</a>
                        </p>
                    </div>
                    <div class="footer-bd ">
                        <p>
                            <a href="# ">关于工程</a>
                            <a href="# ">合作伙伴</a>
                            <a href="# ">联系我们</a>
                            <a href="# ">网站地图</a>
                            <em>© 2018-2025 ldj 版权所有. <a href="#"  title="工程之家">工程之家</a> - Collect from <a href="#" title="工程模板"
                                    >工程模板</a></em>
                        </p>
                    </div>
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
  props: {
    'url': '',
    'data': [Array],
    'handleLoad': false,
    'pageSize': { default: 1, type: Number }
  },
  data () {
    return {
      seckillsHours: 1,
      seckillsMinutes: 20,
      seckillsSeconds: 32
    }
  },
  // 监听属性 类似于data概念
  computed: {
  },
  // 监控data中的数据变化
  watch: {},
  // 方法集合
  methods: {
    setTime () {
      // 倒计时操作
      this.seckillsSeconds--
      if (this.seckillsSeconds === -1) {
        this.seckillsSeconds = 59
        this.seckillsMinutes--
        if (this.seckillsMinutes === -1) {
          this.seckillsMinutes = 59
          this.seckillsHours--
        }
      } else { }

      setTimeout(this.setTime, 1000)
    }
  },
  created () { }, // 生命周期 - 创建完成（可以访问当前this实例）
  mounted () {
    this.setTime()
  }, // 生命周期 - 挂载完成（可以访问DOM元素）
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
