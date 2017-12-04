import unittest

class Spam:
    # see the lovely 'spam song'!
    # https://youtu.be/mBcY3W5WgNU
    def __init__(self, spamNum:int):
        self.song = ""
        for i in range(spamNum):
            self.song += "Spam! "

    def isLovelySpam(self):
        return len(self.song) >= 6*8

    def addMoreSpam(self, spamNum:int):
        for i in range(spamNum):
            self.song += "Spam! "
        return self


class SpamLoverTest(unittest.TestCase):
    # Let's see how much you love spam!
    def setUp(self):
        self.halfDozenSpam = Spam(6)

    def tearDown(self):
        del self.halfDozenSpam

    # test with title prefix "test_" auto run with unittest.main
    def test_SpamGen(self):
        justOneSpam = Spam(1)
        self.assertEqual("Spam! ", justOneSpam.song)

    def test_SpamSong(self):
        spamSong = "Spam! Spam! Spam! Spam! Spam! Spam! Spam! Spam! "
        eightSpam = self.halfDozenSpam.addMoreSpam(2)
        self.assertEqual(spamSong, eightSpam.song)

    def test_notLovelySpam(self):
        self.assertEqual(False, self.halfDozenSpam.isLovelySpam())

    def test_lovelySpam(self):
        lovelySpam = self.halfDozenSpam.addMoreSpam(2)
        self.assertEqual(True, lovelySpam.isLovelySpam())

if __name__ == "__main__":
    unittest.main()