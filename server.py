import flask
import werkzeug
import os 

app = flask.Flask(__name__)

@app.route('/', methods = ['GET', 'POST'])
def handle_request():
    f=open("outin.txt","r+")
    f.truncate()
    imagefile = flask.request.files['image']
    filename = werkzeug.utils.secure_filename(imagefile.filename)
    print("\nReceived image File name : " + imagefile.filename)
    imagefile.save(filename)
    cmd="python3 -m scripts.label_image     --graph=tf_files/retrained_graph.pb      --image="+imagefile.filename 
    os.system(cmd)
    
    op="MATCH SCORES: "
    a=f.readline()
    match=""
    for i in a:
        if i=="(":
            break
        else:
            match+=i
    op=match+"\n"+op+a
    for i in f:
        op+=str(i)
    f.close()
    
    print(op)
    return op

app.run(host="0.0.0.0", port=5000, debug=True)



