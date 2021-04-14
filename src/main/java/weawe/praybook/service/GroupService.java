package weawe.praybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weawe.praybook.domain.Group;
import weawe.praybook.repository.GroupRepository;
import weawe.praybook.web.dto.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Transactional
    public Long save(GroupSaveRequestDto requestDto) {
        return groupRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, GroupUpdateRequestDto requestDto) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        group.update(requestDto.getGroup_name());
        return id;
    }

    public GroupResponseDto findById (Long id) {
        Group entity = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));
        return new GroupResponseDto(entity);
    }

    @Transactional
    public List<GroupListResponseDto> findAllDesc() {
        return groupRepository.findAllDesc().stream()
                .map(GroupListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다 id=" + id));

        groupRepository.delete(group);
    }
}
