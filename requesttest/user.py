# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏

import requests

from requesttest import url

class register(object):

    def __init__(self):
       self.rurl= url.URL()
       self.zhuce=self.rurl.base_url+self.rurl.register
       self.login=self.rurl.base_url+self.rurl.login

#注册成功
    def register_success(self):
        data={
            "mobile":"15175095193",
            "password":"123456"
        }
        self.response=requests.post(url=self.zhuce,data=data).json()
        return self.response


        #获取返回码
    def getcode(self):
        self.code=self.response["code"]
        return self.code


        #返回的数据
    def getmsg(self):
        self.msg=self.response["msg"]
        return self.msg
#登陆成功
    def login_success(self):
        data={
            "mobile":"15175095193",
            "password":"123456"
        }
        self.response1=requests.post(url=self.login,data=data).json()
        return self.response1
        #获取返回码
    def getdata(self):
        self.data=self.response1['data']
        return self.data



        #获取返回码
    def getuid(self):
        self.uid=self.getdata()['uid']
        return self.uid
        # 获取返回码

    def gettoken(self):
        self.token = self.data["token"]
        return self.token



