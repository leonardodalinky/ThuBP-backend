package cn.edu.tsinghua.thubp.web.request;

import cn.edu.tsinghua.thubp.match.enums.RoundGameStrategy;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 创建轮次的请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoundCreateRequest {
    @ApiModelProperty(value = "轮次的名字", required = false)
    private String name;
    @ApiModelProperty(value = "轮次的描述", required = false)
    private String description;
    @ApiModelProperty(value = "参赛单位的 ID 列表", required = true)
    @NotEmpty
    @NotNull
    private List<String> units;
    /**
     * 自动生成 Game 的策略
     */
    @ApiModelProperty(value = "参赛单位预生成策略", required = true)
    @NotNull
    private String autoStrategy;
}
