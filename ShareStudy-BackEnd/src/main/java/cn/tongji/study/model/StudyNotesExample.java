package cn.tongji.study.model;

import java.util.ArrayList;
import java.util.List;

public class StudyNotesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudyNotesExample() {
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

        public Criteria andStudyNoteIdIsNull() {
            addCriterion("study_note_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdIsNotNull() {
            addCriterion("study_note_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdEqualTo(Long value) {
            addCriterion("study_note_id =", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdNotEqualTo(Long value) {
            addCriterion("study_note_id <>", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdGreaterThan(Long value) {
            addCriterion("study_note_id >", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("study_note_id >=", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdLessThan(Long value) {
            addCriterion("study_note_id <", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdLessThanOrEqualTo(Long value) {
            addCriterion("study_note_id <=", value, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdIn(List<Long> values) {
            addCriterion("study_note_id in", values, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdNotIn(List<Long> values) {
            addCriterion("study_note_id not in", values, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdBetween(Long value1, Long value2) {
            addCriterion("study_note_id between", value1, value2, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andStudyNoteIdNotBetween(Long value1, Long value2) {
            addCriterion("study_note_id not between", value1, value2, "studyNoteId");
            return (Criteria) this;
        }

        public Criteria andSharerIdIsNull() {
            addCriterion("sharer_id is null");
            return (Criteria) this;
        }

        public Criteria andSharerIdIsNotNull() {
            addCriterion("sharer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSharerIdEqualTo(Long value) {
            addCriterion("sharer_id =", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdNotEqualTo(Long value) {
            addCriterion("sharer_id <>", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdGreaterThan(Long value) {
            addCriterion("sharer_id >", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sharer_id >=", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdLessThan(Long value) {
            addCriterion("sharer_id <", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdLessThanOrEqualTo(Long value) {
            addCriterion("sharer_id <=", value, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdIn(List<Long> values) {
            addCriterion("sharer_id in", values, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdNotIn(List<Long> values) {
            addCriterion("sharer_id not in", values, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdBetween(Long value1, Long value2) {
            addCriterion("sharer_id between", value1, value2, "sharerId");
            return (Criteria) this;
        }

        public Criteria andSharerIdNotBetween(Long value1, Long value2) {
            addCriterion("sharer_id not between", value1, value2, "sharerId");
            return (Criteria) this;
        }

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(Integer value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(Integer value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(Integer value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(Integer value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(Integer value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(Integer value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<Integer> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<Integer> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(Integer value1, Integer value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(Integer value1, Integer value2) {
            addCriterion("points not between", value1, value2, "points");
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