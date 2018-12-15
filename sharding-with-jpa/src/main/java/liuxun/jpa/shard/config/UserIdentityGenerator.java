package liuxun.jpa.shard.config;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IncrementGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @apiNote 自定义JPA的主键生成策略(采用sharding-jdbc自带的snowflake算法)
 * @author liuxun
 */
@Component
@GenericGenerator(name = "UserIdentityGenerator",strategy = "liuxun.jpa.shard.config.UserIdentityGenerator")
public class UserIdentityGenerator extends IncrementGenerator {
    @Override
    public synchronized Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return new DefaultKeyGenerator().generateKey();
    }
}
