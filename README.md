# xy-mp-plus

一个动态表的的插件, 依赖Mybatis-Plus, 采用注解形式, 主要支持多层级的嵌套.

-- tableName1 start --
  //do something use tableName1
  -- tableName2 start --
     //do something use tableName2
  -- tableName2 end --
  //do something use tableName1
-- tableName1 end --
