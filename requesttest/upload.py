# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏
# 创建时间： 2018/10/16 19:19
from requesttest import url
from requesttest import user
import requests
class UploadPicControl(object):
    def __init__(self):
        self.URL = url.URL()
        self.uploadpic=self.URL.base_online_url+self.URL.upload_pic
        self.login=user.register()

    def uploadpic_Success(self):
       self.denglu=self.login.login_success()
       self.uid=self.denglu.getuid()
       data={'uid':self.uid}
       files ={'file':('ww.png',open('D:/ww.png','rb'),'image/png')}
       self.response= requests.post(url=self.uploadpic,data=data,files=files).json()
       return  self.response
