# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏
# 创建时间： 2018/10/16 14:13

import unittest
from requesttest import user
class Register(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        cls.success=user.register()

    def test_register(self):
        self.response=self.success.register_success()
        print(self.response)
        self.assertEqual(self.success.getcode(),str())
