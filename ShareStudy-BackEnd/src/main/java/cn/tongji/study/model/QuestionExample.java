package cn.tongji.study.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Long value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Long value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Long value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Long value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Long> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Long> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Long value1, Long value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdIsNull() {
            addCriterion("question_asker_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdIsNotNull() {
            addCriterion("question_asker_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdEqualTo(Long value) {
            addCriterion("question_asker_id =", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdNotEqualTo(Long value) {
            addCriterion("question_asker_id <>", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdGreaterThan(Long value) {
            addCriterion("question_asker_id >", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_asker_id >=", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdLessThan(Long value) {
            addCriterion("question_asker_id <", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdLessThanOrEqualTo(Long value) {
            addCriterion("question_asker_id <=", value, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdIn(List<Long> values) {
            addCriterion("question_asker_id in", values, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdNotIn(List<Long> values) {
            addCriterion("question_asker_id not in", values, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdBetween(Long value1, Long value2) {
            addCriterion("question_asker_id between", value1, value2, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andQuestionAskerIdNotBetween(Long value1, Long value2) {
            addCriterion("question_asker_id not between", value1, value2, "questionAskerId");
            return (Criteria) this;
        }

        public Criteria andRewardPointsIsNull() {
            addCriterion("reward_points is null");
            return (Criteria) this;
        }

        public Criteria andRewardPointsIsNotNull() {
            addCriterion("reward_points is not null");
            return (Criteria) this;
        }

        public Criteria andRewardPointsEqualTo(Integer value) {
            addCriterion("reward_points =", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsNotEqualTo(Integer value) {
            addCriterion("reward_points <>", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsGreaterThan(Integer value) {
            addCriterion("reward_points >", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("reward_points >=", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsLessThan(Integer value) {
            addCriterion("reward_points <", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsLessThanOrEqualTo(Integer value) {
            addCriterion("reward_points <=", value, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsIn(List<Integer> values) {
            addCriterion("reward_points in", values, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsNotIn(List<Integer> values) {
            addCriterion("reward_points not in", values, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsBetween(Integer value1, Integer value2) {
            addCriterion("reward_points between", value1, value2, "rewardPoints");
            return (Criteria) this;
        }

        public Criteria andRewardPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("reward_points not between", value1, value2, "rewardPoints");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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