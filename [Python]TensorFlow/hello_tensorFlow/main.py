import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data
# mnist handwrite integer images
mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)
def SetPlaceholders():
    # set variables and placeholders function
    print('Setting up placeholders and variables...')
    # x for placeholder
    x = tf.placeholder(tf.float32, [None, 784])
    # W for weight
    W = tf.Variable(tf.zeros([784, 10]))
    # b for bias
    b = tf.Variable(tf.zeros([10]))
    # y for softmax regression value
    y = tf.nn.softmax(tf.matmul(x, W) + b)
    # y_ for modeling output placeholder
    y_ = tf.placeholder(tf.float32, [None, 10])
    # get cross entropy
    cross_entropy = tf.reduce_mean(-tf.reduce_sum(y_ * tf.log(y), reduction_indices=[1]))
    # use gradient descent
    train_step = tf.train.GradientDescentOptimizer(0.5).minimize(cross_entropy)
    # tensorflow initialize
    init = tf.global_variables_initializer()
    # setting up sessions
    sess = tf.Session()
    sess.run(init)
    return x,W,b,y,y_,cross_entropy,train_step,sess
def StartLearning(train_step,x,y_,session):
    # learning with tf function
    print('Start Learning...')
    for i in range(1000):
        if i % 100 == 0 :
            print(i,'th learning...')
        batch_xs, batch_ys = mnist.train.next_batch(100)
        session.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})
def EvalModel(x,y,y_,session):
    # evaluate model func
    print('Evaluating Model...')
    correct_prediction = tf.equal(tf.argmax(y,1), tf.argmax(y_,1))
    accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    print(session.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
def main():
    # main func
    x,W,b,y,y_,cross_entropy,train_step,sess = SetPlaceholders()
    StartLearning(train_step, x, y_, sess)
    EvalModel(x, y, y_, sess)
if __name__ == '__main__':
  main()
