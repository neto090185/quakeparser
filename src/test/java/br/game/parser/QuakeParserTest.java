package br.game.parser;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class QuakeParserTest {
    private QuakeParser quakeParser = new QuakeParser();


    @Test
    public void extractActionInitGame() throws Exception {
        String initGame = "0:00 InitGame: \\sv_floodProtect\\1\\sv_maxPing\\0\\sv_minPing\\0\\sv_maxRate\\10000\\sv_minRate\\0\\sv_hostname\\Code Miner Server\\g_gametype\\0\\sv_privateClients\\2\\sv_maxclients\\16\\sv_allowDownload\\0\\dmflags\\0\\fraglimit\\20\\timelimit\\15\\g_maxGameClients\\0\\capturelimit\\8\\version\\ioq3 1.36 linux-x86_64 Apr 12 2009\\protocol\\68\\mapname\\q3dm17\\gamename\\baseq3\\g_needpass\\0";
        assertThat(quakeParser.extractAction(initGame), is("InitGame"));
    }
    @Test
    public void extractActionKill() throws Exception {
        String killLine = "20:54 Kill: 1022 2 22: <world> killed Isgalamido by MOD_TRIGGER_HURT";
        assertThat(quakeParser.extractAction(killLine), is("Kill"));
    }

    @Test
    public void extractPlayerMocinha() throws Exception {
        String line = "0:27 ClientUserinfoChanged: 2 n\\Mocinha\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0";
        assertThat(quakeParser.extractPlayer(line), is("Mocinha"));
    }
    @Test
    public void extractPlayerDono_da_Bola() throws Exception {
        String line = "1:47 ClientUserinfoChanged: 2 n\\Dono da Bola\\t\\0\\model\\sarge\\hmodel\\sarge\\g_redteam\\\\g_blueteam\\\\c1\\4\\c2\\5\\hc\\95\\w\\0\\l\\0\\tt\\0\\tl\\0";
        assertThat(quakeParser.extractPlayer(line), is("Dono da Bola"));
    }


}