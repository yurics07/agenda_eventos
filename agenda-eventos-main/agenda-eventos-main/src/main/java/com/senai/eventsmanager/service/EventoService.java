package com.senai.eventsmanager.service;

import com.senai.eventsmanager.dto.EventoDTO;
import com.senai.eventsmanager.entity.Evento;
import com.senai.eventsmanager.enums.EventoEnum;
import com.senai.eventsmanager.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    EventoRepository repository;


    public List<EventoDTO> findByTitulo(EventoEnum titulo){
        List<Evento> eventos = repository.findByTitulo(titulo);
        List<EventoDTO> eventoDTOs = new ArrayList<>();
        for (Evento evento : eventos){
            eventoDTOs.add(toDto(evento));
        }
        return eventoDTOs;
    }


    public EventoDTO findById(Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow();
        EventoDTO eventoCreateDTO = toDto(evento);
        return eventoCreateDTO;
    }

    public EventoDTO save(EventoDTO eventoDto) {
        Evento evento = toEntity(eventoDto);
        evento = eventoRepository.save(evento);
        return toDto(evento);
    }

    public EventoDTO update(Long id, EventoDTO eventoDto) {
        Evento evento = toEntity(eventoDto);
        evento.setId(id);
        evento = eventoRepository.save(evento);
        return toDto(evento);
    }

    public void deleteById(Long id) {
        eventoRepository.deleteById(id);
    }

    public List<EventoDTO> calendario(String dataInicio, String dataFinal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDateTime inicioFormatado = LocalDate.parse(dataInicio, formatter).atStartOfDay();
        LocalDateTime fimFormDate = LocalDate.parse(dataFinal, formatter).atStartOfDay();

        List<Evento> eventos = eventoRepository.calendario(inicioFormatado, fimFormDate);
        List<EventoDTO> eventoDTOs = new ArrayList<>();

        for(Evento evento: eventos){
            eventoDTOs.add(toDto(evento));
        }
                return eventoDTOs;
    }

    public List<EventoDTO> findAll() {
        List<Evento> eventos = eventoRepository.findAll();

        List<EventoDTO> eventosDTO = new ArrayList<>();

        for (Evento evento : eventos) {
            eventosDTO.add(toDto(evento));
        }
        return eventosDTO;
    }

    public EventoDTO toDto(Evento evento) {
        EventoDTO dto = new EventoDTO();
        BeanUtils.copyProperties(evento, dto);

        return dto;
    }

    public Evento toEntity(EventoDTO dto) {
        Evento evento = new Evento();
        BeanUtils.copyProperties(dto, evento);

        return evento;
    }
}
