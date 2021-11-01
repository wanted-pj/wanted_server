package com.wanted_server.Class;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TeamDto {
    private List<Personal> personals = new ArrayList<>();
    private Boolean leader;
}