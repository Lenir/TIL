import os

file = open("newDir/testFile.txt", 'w', encoding='utf-8')
file.write("SPAM! ")
file.write("SPAM! ")
file.write("SPAM!\n")
file.write("Lovely SPAM!\n")
file.write("Wonderful SPAM!\n")
file.write("스 팸!")
file.close()

file = open("newDir/testFile.txt", 'r', encoding='utf-8')
fileText = file.read()
file.close()

# folder = os.makedirs("newDir")
# folder = os.makedirs("newDir/subDir")

print(fileText)