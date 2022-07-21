package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        //Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }
        @Test
        public void testSelectByConditionSingle() throws IOException {
            //接收参数
            int status = 1;
            String companyName = "华为";
            String brandName = "华为";

            //处理参数
            companyName = "%" + companyName + "%";
            brandName ="%" + brandName + "%";

            //封装对象
            Brand brand = new Brand();
            //brand.setStatus(status);
            //brand.setCompanyName(companyName);
            //brand.setBrandName(brandName);

            //Map map = new HashMap();
            ////map.put("status",status);
            //map.put("companyName",companyName);
            //map.put("brandName",brandName);


            //1.获取SqlSessionFactory
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //2.获取SqlSession
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //3.获取Mapper的代理对象
            BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

            //4.执行方法
            List<Brand> brands = brandMapper.selectByConditionSingle(brand);
            System.out.println(brands);

            //5.释放资源
            sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "framework";
        String brandName = "阿尔宙斯";
        String description = "阿尔宙斯手机";
        int ordered = 100;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //Map map = new HashMap();
        ////map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交事务

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "framework";
        String brandName = "阿尔宙斯";
        String description = "阿尔宙斯手机";
        int ordered = 100;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //Map map = new HashMap();
        ////map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交事务

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);


        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "framework123";
        String brandName = "阿尔宙斯123";
        String description = "阿尔宙斯手机123";
        int ordered = 100;
        int id = 6;


        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);
        //brand.setDescription(description);
        //brand.setOrdered(ordered);
        brand.setId(id);

        //Map map = new HashMap();
        ////map.put("status",status);
        //map.put("companyName",companyName);
        //map.put("brandName",brandName);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交事务

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);


        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 6;


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交事务

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteById(id);


        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids = {1,2,3};


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交事务

        //3.获取Mapper的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);


        //提交事务
        //sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }
}
