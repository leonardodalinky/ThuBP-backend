package cn.edu.tsinghua.thubp.web.request;

import cn.edu.tsinghua.thubp.common.annotation.AutoModify;
import cn.edu.tsinghua.thubp.common.intf.ModifiableSource;
import cn.edu.tsinghua.thubp.match.enums.GameStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 修改比赛的请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameModifyRequest implements ModifiableSource {
    @ApiModelProperty(value = "比赛的状态", required = false)
    @org.jetbrains.annotations.Nullable
    @AutoModify
    private GameStatus status;
    @ApiModelProperty(value = "参赛单位 0 的 ID", required = false)
    @org.jetbrains.annotations.Nullable
    private String unit0;
    @ApiModelProperty(value = "参赛单位 1 的 ID", required = false)
    @org.jetbrains.annotations.Nullable
    private String unit1;
    @ApiModelProperty(value = "比赛记分板类型", required = false)
    @org.jetbrains.annotations.Nullable
    private String scoreboardTypeId;
    @ApiModelProperty(value = "比赛记分板配置", required = false)
    @org.jetbrains.annotations.Nullable
    private JsonNode scoreboardConfig;
    @ApiModelProperty(value = "比赛记分结果", required = false)
    @org.jetbrains.annotations.Nullable
    private JsonNode result;
}
