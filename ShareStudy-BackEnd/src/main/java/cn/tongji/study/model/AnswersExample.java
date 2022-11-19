package cn.tongji.study.model;

import java.util.ArrayList;
import java.util.List;

public class AnswersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswersExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Long value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Long value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Long value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Long value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Long value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Long> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Long> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Long value1, Long value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Long value1, Long value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIsNull() {
            addCriterion("answerer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIsNotNull() {
            addCriterion("answerer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswererIdEqualTo(Long value) {
            addCriterion("answerer_id =", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotEqualTo(Long value) {
            addCriterion("answerer_id <>", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdGreaterThan(Long value) {
            addCriterion("answerer_id >", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answerer_id >=", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdLessThan(Long value) {
            addCriterion("answerer_id <", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdLessThanOrEqualTo(Long value) {
            addCriterion("answerer_id <=", value, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdIn(List<Long> values) {
            addCriterion("answerer_id in", values, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotIn(List<Long> values) {
            addCriterion("answerer_id not in", values, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdBetween(Long value1, Long value2) {
            addCriterion("answerer_id between", value1, value2, "answererId");
            return (Criteria) this;
        }

        public Criteria andAnswererIdNotBetween(Long value1, Long value2) {
            addCriterion("answerer_id not between", value1, value2, "answererId");
            return (Criteria) this;
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

        public Criteria andAdoptedIsNull() {
            addCriterion("adopted is null");
            return (Criteria) this;
        }

        public Criteria andAdoptedIsNotNull() {
            addCriterion("adopted is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptedEqualTo(Boolean value) {
            addCriterion("adopted =", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedNotEqualTo(Boolean value) {
            addCriterion("adopted <>", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedGreaterThan(Boolean value) {
            addCriterion("adopted >", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("adopted >=", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedLessThan(Boolean value) {
            addCriterion("adopted <", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedLessThanOrEqualTo(Boolean value) {
            addCriterion("adopted <=", value, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedIn(List<Boolean> values) {
            addCriterion("adopted in", values, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedNotIn(List<Boolean> values) {
            addCriterion("adopted not in", values, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedBetween(Boolean value1, Boolean value2) {
            addCriterion("adopted between", value1, value2, "adopted");
            return (Criteria) this;
        }

        public Criteria andAdoptedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("adopted not between", value1, value2, "adopted");
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