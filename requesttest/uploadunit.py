# _*_ coding: utf-8 _*_
# 作者    ： 焦子鹏
# 创建时间： 2018/10/16 19:24
import unittest
from requesttest import upload

class upload(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
       cls.uploadpic=upload.UploadPicControl()

    def test_upload(self):
        self.response=self.uploadpic.uploadpic_Success()
        print(self.response)
