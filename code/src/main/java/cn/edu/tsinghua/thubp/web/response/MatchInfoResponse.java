package cn.edu.tsinghua.thubp.web.response;

import cn.edu.tsinghua.thubp.match.entity.Match;
import cn.edu.tsinghua.thubp.match.entity.MatchToken;
import cn.edu.tsinghua.thubp.match.entity.RefereeToken;
import cn.edu.tsinghua.thubp.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.net.URL;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MatchInfoResponse extends SimpleResponse {
    @ApiModelProperty(value = "赛事 ID", required = true)
    private String matchId;
    @ApiModelProperty(value = "组织者 ID", required = true)
    private String organizerUserId;
    @ApiModelProperty(value = "赛事名字", required = true)
    private String name;
    @ApiModelProperty(value = "赛事描述", required = true)
    private String description;
    @ApiModelProperty(value = "赛事预览图", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private URL preview;
    @ApiModelProperty(value = "赛事预览大图", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private URL previewLarge;
    @ApiModelProperty(value = "赛事类型 ID", required = true)
    private String matchTypeId;
    @ApiModelProperty(value = "裁判邀请码", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RefereeToken refereeToken;
    @ApiModelProperty(value = "公开报名", required = true)
    private Boolean publicSignUp;
    @ApiModelProperty(value = "赛事邀请码", required = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private MatchToken matchToken;

    public MatchInfoResponse(Match match) {
        this.matchId = match.getMatchId();
        this.organizerUserId = match.getOrganizerUserId();
        this.name = match.getName();
        this.description = match.getDescription();
        this.preview = match.getPreview();
        this.previewLarge = match.getPreviewLarge();
        this.matchTypeId = match.getMatchTypeId();
        this.refereeToken = match.getRefereeToken();
        this.publicSignUp = match.getPublicSignUp();
        this.matchToken = match.getMatchToken();
    }
}
