package com.lzt.order.config;


import com.lzt.order.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
public class IdWorderConfig {

    @Bean
    public SnowflakeIdWorker initIdWorker() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(1);
        jedisPoolConfig.setMaxWaitMillis(0);
        jedisPoolConfig.setMaxTotal(1);
        jedisPoolConfig.setMinIdle(1);

        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("172.31.176.81", 6379));

        JedisCluster jedisCluster = new JedisCluster(nodes, jedisPoolConfig);

        String host = getLocalMac();
        String workerId = jedisCluster.hget("useridworker", host);
        try{
            jedisCluster.close();
        }catch (Exception e){

        }

        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(Long.valueOf(workerId), 0);
        return idWorker;
    }


    public static String getLocalMac() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append(":");
                }
                //字节转换为整数
                int temp = mac[i] & 0xff;
                String str = Integer.toHexString(temp);
                if (str.length() == 1) {
                    sb.append("0" + str);
                } else {
                    sb.append(str);
                }
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String args[]) {
        String host = getLocalMac();
        System.out.println(host);
    }
}
