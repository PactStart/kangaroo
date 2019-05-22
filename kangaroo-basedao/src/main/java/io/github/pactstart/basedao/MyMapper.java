package io.github.pactstart.basedao;

import tk.mybatis.mapper.common.*;

public interface MyMapper<T> extends BaseMapper<T>, ExampleMapper<T>, ConditionMapper<T>, IdsMapper<T>, MySqlMapper<T>, Marker {

}
