package test.mq.rocketMQ.demo;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.io.UnsupportedEncodingException;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 消费者
 *
 * @author : flutterdash@qq.com
 * @date : 2020年09月24日 21:37
 */
public class Consumer {

    public static void main(String[] args) throws Exception {
        //创建一个消息消费者，并设置一个消息消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("zs_consumer_group");
        //指定NameServer地址
        consumer.setNamesrvAddr("localhost:9876");
        //设置Consumer第一次启动时是从队列头部还是队列尾部开始消费的
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅指定Topic下的所有消息
        consumer.subscribe("topic_example_java","*");
        //注册消息监听器
        consumer.registerMessageListener((List<MessageExt> list, ConsumeConcurrentlyContext context) -> {
            //默认list里只有一条消息，可以通过设置参数来批量接收消息
            if(list!= null) {
                for(MessageExt ext: list) {
                    System.out.println(new Date()+ new String(ext.getBody(), StandardCharsets.UTF_8));
                }
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        //消息者对象在使用之前必须要调用start方法初始化
        consumer.start();
        System.out.println("消息消费者已启动");
    }

}
