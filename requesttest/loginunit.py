# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏
# 创建时间： 2018/10/16 15:00
import unittest
from requesttest import user
class Login(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.success=user.register()

    def test_login(self):
       self.testlogin= self.success.login_success()
       print(self.testlogin)
       self.uid=self.success.getuid()
       self.assertEqual("21436",str(self.uid))