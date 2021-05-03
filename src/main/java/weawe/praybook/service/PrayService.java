package weawe.praybook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import weawe.praybook.domain.Pray;
import weawe.praybook.repository.PrayRepository;
import weawe.praybook.web.dto.PrayListResponseDto;
import weawe.praybook.web.dto.PrayResponseDto;
import weawe.praybook.web.dto.PraySaveRequestDto;
import weawe.praybook.web.dto.PrayUpdateRequestDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PrayService {
    private final PrayRepository prayRepository;

    @Transactional
    public Long save(PraySaveRequestDto requestDto) {
        return prayRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PrayUpdateRequestDto requestDto) {
        Pray pray = prayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 기도 없습니다. id="+ id));
        pray.update(requestDto.getPrayType(), requestDto.getPrayTitle(), requestDto.getPrayContent());
        return id;
    }

    public PrayResponseDto findById (Long id) {
        Pray entity = prayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 기도 없습니다. id="+ id));
        return new PrayResponseDto(entity);
    }

    @Transactional
    public List<PrayListResponseDto> findAllDesc() {
        return prayRepository.findAllDesc().stream()
                .map(PrayListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Pray pray = prayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 기도 없습니다 id=" + id));

        prayRepository.delete(pray);
    }
}
