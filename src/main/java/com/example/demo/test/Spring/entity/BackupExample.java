package com.example.demo.test.Spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackupExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table backup
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table backup
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table backup
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public BackupExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table backup
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table backup
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBackupIdIsNull() {
            addCriterion("backUp_id is null");
            return (Criteria) this;
        }

        public Criteria andBackupIdIsNotNull() {
            addCriterion("backUp_id is not null");
            return (Criteria) this;
        }

        public Criteria andBackupIdEqualTo(Integer value) {
            addCriterion("backUp_id =", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdNotEqualTo(Integer value) {
            addCriterion("backUp_id <>", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdGreaterThan(Integer value) {
            addCriterion("backUp_id >", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("backUp_id >=", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdLessThan(Integer value) {
            addCriterion("backUp_id <", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdLessThanOrEqualTo(Integer value) {
            addCriterion("backUp_id <=", value, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdIn(List<Integer> values) {
            addCriterion("backUp_id in", values, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdNotIn(List<Integer> values) {
            addCriterion("backUp_id not in", values, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdBetween(Integer value1, Integer value2) {
            addCriterion("backUp_id between", value1, value2, "backupId");
            return (Criteria) this;
        }

        public Criteria andBackupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("backUp_id not between", value1, value2, "backupId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdIsNull() {
            addCriterion("facility_id is null");
            return (Criteria) this;
        }

        public Criteria andFacilityIdIsNotNull() {
            addCriterion("facility_id is not null");
            return (Criteria) this;
        }

        public Criteria andFacilityIdEqualTo(Integer value) {
            addCriterion("facility_id =", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdNotEqualTo(Integer value) {
            addCriterion("facility_id <>", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdGreaterThan(Integer value) {
            addCriterion("facility_id >", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("facility_id >=", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdLessThan(Integer value) {
            addCriterion("facility_id <", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdLessThanOrEqualTo(Integer value) {
            addCriterion("facility_id <=", value, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdIn(List<Integer> values) {
            addCriterion("facility_id in", values, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdNotIn(List<Integer> values) {
            addCriterion("facility_id not in", values, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdBetween(Integer value1, Integer value2) {
            addCriterion("facility_id between", value1, value2, "facilityId");
            return (Criteria) this;
        }

        public Criteria andFacilityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("facility_id not between", value1, value2, "facilityId");
            return (Criteria) this;
        }

        public Criteria andStudyuidIsNull() {
            addCriterion("studyUid is null");
            return (Criteria) this;
        }

        public Criteria andStudyuidIsNotNull() {
            addCriterion("studyUid is not null");
            return (Criteria) this;
        }

        public Criteria andStudyuidEqualTo(String value) {
            addCriterion("studyUid =", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidNotEqualTo(String value) {
            addCriterion("studyUid <>", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidGreaterThan(String value) {
            addCriterion("studyUid >", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidGreaterThanOrEqualTo(String value) {
            addCriterion("studyUid >=", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidLessThan(String value) {
            addCriterion("studyUid <", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidLessThanOrEqualTo(String value) {
            addCriterion("studyUid <=", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidLike(String value) {
            addCriterion("studyUid like", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidNotLike(String value) {
            addCriterion("studyUid not like", value, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidIn(List<String> values) {
            addCriterion("studyUid in", values, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidNotIn(List<String> values) {
            addCriterion("studyUid not in", values, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidBetween(String value1, String value2) {
            addCriterion("studyUid between", value1, value2, "studyuid");
            return (Criteria) this;
        }

        public Criteria andStudyuidNotBetween(String value1, String value2) {
            addCriterion("studyUid not between", value1, value2, "studyuid");
            return (Criteria) this;
        }

        public Criteria andModalityIsNull() {
            addCriterion("modality is null");
            return (Criteria) this;
        }

        public Criteria andModalityIsNotNull() {
            addCriterion("modality is not null");
            return (Criteria) this;
        }

        public Criteria andModalityEqualTo(String value) {
            addCriterion("modality =", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityNotEqualTo(String value) {
            addCriterion("modality <>", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityGreaterThan(String value) {
            addCriterion("modality >", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityGreaterThanOrEqualTo(String value) {
            addCriterion("modality >=", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityLessThan(String value) {
            addCriterion("modality <", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityLessThanOrEqualTo(String value) {
            addCriterion("modality <=", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityLike(String value) {
            addCriterion("modality like", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityNotLike(String value) {
            addCriterion("modality not like", value, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityIn(List<String> values) {
            addCriterion("modality in", values, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityNotIn(List<String> values) {
            addCriterion("modality not in", values, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityBetween(String value1, String value2) {
            addCriterion("modality between", value1, value2, "modality");
            return (Criteria) this;
        }

        public Criteria andModalityNotBetween(String value1, String value2) {
            addCriterion("modality not between", value1, value2, "modality");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table backup
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table backup
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}