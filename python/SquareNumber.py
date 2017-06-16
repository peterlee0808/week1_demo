from flask import Flask


#TCP_IP = '192.168.18.60'
#TCP_PORT = 30


SquareNumber = Flask(__name__)
#@SquareNumber.route('/')
#def index():
    #return "hi"

@SquareNumber.route('/python/square/<int:number>', methods = ['GET'])
def get_account(number):
    square = str(number * number)
    statement = "Square of " + str(number) + " is " + square + '\n'
    #return jsonify( { 'account': account[0] } )
    print statement
    return statement

if __name__ == '__main__':
    SquareNumber.run(debug=True,host='0.0.0.0')