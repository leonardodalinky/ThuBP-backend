package cn.edu.tsinghua.thubp.match.entity;

import cn.edu.tsinghua.thubp.comment.intf.Commentable;
import cn.edu.tsinghua.thubp.common.entity.AuditBase;
import cn.edu.tsinghua.thubp.common.intf.ModifiableSource;
import cn.edu.tsinghua.thubp.common.intf.ModifiableTarget;
import cn.edu.tsinghua.thubp.match.enums.GameStatus;
import cn.edu.tsinghua.thubp.plugin.GameResult;
import cn.edu.tsinghua.thubp.plugin.api.scoreboard.GameScoreboardConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.mongodb.DBObject;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 真正的一场比赛，只准有两个参赛单位
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "game")
public class Game extends AuditBase implements ModifiableTarget, Commentable {
    @Transient
    public static final String SEQUENCE_NAME = "game_sequence";

    public Game(String unit0, @org.jetbrains.annotations.Nullable String unit1) {
        this.unit0 = unit0;
        this.unit1 = unit1;
    }

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String gameId;
    /**
     * 单场比赛状态
     */
    @lombok.NonNull
    GameStatus status;
    /**
     * 参赛单位 0
     */
    @lombok.NonNull
    private String unit0;
    /**
     * 参赛单位 1
     */
    @org.jetbrains.annotations.Nullable
    private String unit1;
    /**
     * 记分板
     */
    @org.jetbrains.annotations.Nullable
    private String scoreboardTypeId;
    /**
     * 记分板配置
     */
    @JsonDeserialize(using = JsonNodeDeserializer.class)
    @org.jetbrains.annotations.Nullable
    private GameScoreboardConfig scoreboardConfig;
    /**
     * 记分板内容
     */
    @JsonSerialize(using = JsonValueSerializer.class)
    @org.jetbrains.annotations.Nullable
    private GameResult result;
    /**
     * 评论的 ID
     */
    @lombok.NonNull
    private List<String> comments;
    // TODO: 单场比赛中的其他信息
}
