/*
 * This file is generated by jOOQ.
*/
package com.lesson.boot.docs.jooq.generator.tables;


import com.lesson.boot.docs.jooq.generator.Indexes;
import com.lesson.boot.docs.jooq.generator.Keys;
import com.lesson.boot.docs.jooq.generator.Pandadb;
import com.lesson.boot.docs.jooq.generator.tables.records.TActivityRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TActivity extends TableImpl<TActivityRecord> {

    private static final long serialVersionUID = -755772658;

    /**
     * The reference instance of <code>pandadb.t_activity</code>
     */
    public static final TActivity T_ACTIVITY = new TActivity();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TActivityRecord> getRecordType() {
        return TActivityRecord.class;
    }

    /**
     * The column <code>pandadb.t_activity.id</code>.
     */
    public final TableField<TActivityRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>pandadb.t_activity.banner_url</code>.
     */
    public final TableField<TActivityRecord, String> BANNER_URL = createField("banner_url", org.jooq.impl.SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>pandadb.t_activity.name</code>.
     */
    public final TableField<TActivityRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>pandadb.t_activity.sequence</code>.
     */
    public final TableField<TActivityRecord, Integer> SEQUENCE = createField("sequence", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>pandadb.t_activity.url</code>.
     */
    public final TableField<TActivityRecord, String> URL = createField("url", org.jooq.impl.SQLDataType.VARCHAR(1024), this, "");

    /**
     * The column <code>pandadb.t_activity.begin_time</code>.
     */
    public final TableField<TActivityRecord, Long> BEGIN_TIME = createField("begin_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>pandadb.t_activity.end_time</code>.
     */
    public final TableField<TActivityRecord, Long> END_TIME = createField("end_time", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>pandadb.t_activity.status</code>.
     */
    public final TableField<TActivityRecord, Byte> STATUS = createField("status", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>pandadb.t_activity.type</code>.
     */
    public final TableField<TActivityRecord, Byte> TYPE = createField("type", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>pandadb.t_activity.country_id</code>.
     */
    public final TableField<TActivityRecord, Long> COUNTRY_ID = createField("country_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>pandadb.t_activity.app_version</code>. 支撑app版本
     */
    public final TableField<TActivityRecord, Integer> APP_VERSION = createField("app_version", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "支撑app版本");

    /**
     * Create a <code>pandadb.t_activity</code> table reference
     */
    public TActivity() {
        this(DSL.name("t_activity"), null);
    }

    /**
     * Create an aliased <code>pandadb.t_activity</code> table reference
     */
    public TActivity(String alias) {
        this(DSL.name(alias), T_ACTIVITY);
    }

    /**
     * Create an aliased <code>pandadb.t_activity</code> table reference
     */
    public TActivity(Name alias) {
        this(alias, T_ACTIVITY);
    }

    private TActivity(Name alias, Table<TActivityRecord> aliased) {
        this(alias, aliased, null);
    }

    private TActivity(Name alias, Table<TActivityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Pandadb.PANDADB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.T_ACTIVITY_BEGIN_TIME, Indexes.T_ACTIVITY_END_TIME, Indexes.T_ACTIVITY_PRIMARY, Indexes.T_ACTIVITY_STATUS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TActivityRecord, Long> getIdentity() {
        return Keys.IDENTITY_T_ACTIVITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TActivityRecord> getPrimaryKey() {
        return Keys.KEY_T_ACTIVITY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TActivityRecord>> getKeys() {
        return Arrays.<UniqueKey<TActivityRecord>>asList(Keys.KEY_T_ACTIVITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivity as(String alias) {
        return new TActivity(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TActivity as(Name alias) {
        return new TActivity(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TActivity rename(String name) {
        return new TActivity(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TActivity rename(Name name) {
        return new TActivity(name, null);
    }
}