# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏
# 创建时间： 2018/10/15 18:53

class URL(object):
    #生产环境的接口地址
    base_url ="https://www.zhaoapi.cn"

    #注册
    register = "/user/reg"
    #登录
    login="/user/login"
    #获取用户信息
    userinfo="/user/getUserInfo"

    #上传头像

    #上传头像
    upload_pic="/file/upload"