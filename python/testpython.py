import json
a = {
    "name1":100,
    "name2":"hello world",
    "name3list":["a","b","c"]
        }
with open('/root/test.json','w') as file:
    print('print json to file',file.name,a)
    json.dump(a,file,indent=4)
