import pickle

shoplistfile = 'shoplist.data'
shoplist = ['apple', 'mango', 'carrot', 'coconub']

f = open(shoplistfile, 'wb')
pickle.dump(shoplist, f)
f.close()

del shoplist
f = open(shoplistfile, 'rb')
storedlist = pickle.load(f)
f.close()

print(storedlist)