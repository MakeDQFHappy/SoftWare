package cn.tongji.study.model;

import java.io.Serializable;

public class Friend implements Serializable {
    private Long friendKey;

    private Long userId;

    private Long friendId;

    private static final long serialVersionUID = 1L;

    public Long getFriendKey() {
        return friendKey;
    }

    public void setFriendKey(Long friendKey) {
        this.friendKey = friendKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", friendKey=").append(friendKey);
        sb.append(", userId=").append(userId);
        sb.append(", friendId=").append(friendId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}