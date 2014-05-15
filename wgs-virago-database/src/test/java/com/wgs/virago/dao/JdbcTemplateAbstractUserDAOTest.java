package com.wgs.virago.dao;

import org.springframework.test.context.ContextConfiguration;
import com.usg.ssg1.common.dao.AbstractUserDAOTest;

@ContextConfiguration(locations={"classpath:jdbc-persistence-context.xml"})
public class JdbcTemplateAbstractUserDAOTest extends AbstractUserDAOTest {
}
