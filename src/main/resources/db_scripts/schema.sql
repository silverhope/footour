CREATE SCHEMA foot;

CREATE TABLE foot.period (
	id 				serial PRIMARY KEY,
	name 			varchar(100),
	description 	varchar(100),
	number_of_days 	int
);

CREATE TABLE foot.season (
	id 			serial PRIMARY KEY,
	from_date 	timestamp,
	to_date 	timestamp
);

CREATE TABLE foot.championship (
	id 			serial PRIMARY KEY,
	season_id 	int
);

CREATE TABLE foot.party (
	id 					serial PRIMARY KEY,
	name 				varchar(50),
	season_id 			int,
	championship_id 	int
);

CREATE TABLE foot.game (
	id 			bigserial PRIMARY KEY,
	is_party_game 	boolean,
	season_id 	int,
	party_id 	int,
	team_a_id 	int,
	team_b_id 	int,
	score_a 	int,
	score_b 	int,
	game_day 	int
);

CREATE TABLE foot.team (
	id 			serial PRIMARY KEY,
	name 		varchar(50),
	value 		bigint,
	budget 		bigint
);

CREATE TABLE foot.team_statistics (
	id 				serial PRIMARY KEY,
	team_id  		int,
	season_id 		int,
	shots 			int,
	shots_on_target int,
	possession 		int,
	tackles 		int,
	fouls 			int,
	corners 		int,
	shot_accuracy 	int,
	pass_accuracy 	int
);

CREATE TABLE foot.party_team (
	id 			bigserial PRIMARY KEY,
	party_id 	int,
	team_id 	int
);

CREATE TABLE foot.end_user (
	id 			bigserial PRIMARY KEY,
	username 	varchar(50),
	password 	varchar(50),
	email 		varchar(100),
	psn_id 		varchar(50)
);

CREATE TABLE foot.nationality (
	id 			serial PRIMARY KEY,
	name 		varchar(100),
	description varchar(100)
);

CREATE TABLE foot.post_type (
    id          serial PRIMARY KEY,
    name        varchar(100),
    description varchar(50)
);

CREATE TABLE foot.post (
	id 			    serial PRIMARY KEY,
	name 		    varchar(100),
	description     varchar(50),
	post_type_id    int
);

CREATE TABLE foot.contract (
	id 			bigserial PRIMARY KEY,
	name 		varchar(50),
	salary 		int,
	years 		int,
	buy_out 	int
);

CREATE TABLE foot.shooting (
	id 					bigserial PRIMARY KEY,
	shooting_percentage int,
	goals 				int,
	on_target 			int,
	off_target 			int
);

CREATE TABLE foot.passes (
	id 					bigserial PRIMARY KEY,
	passes_percentage 	int,
	assists 			int,
	completed_short 	int,
	completed_medium 	int,
	completed_long 		int,
	failed_short 		int,
	failed_medium 		int,
	failed_long 		int,
	key_passes 			int,
	crosses_successful 	int,
	crosses_failed 		int
);

CREATE TABLE foot.movement (
	id 								bigserial PRIMARY KEY,
	key_dribbles 					int,
	fouled 							int,
	successful_one_on_one_dribbles 	int
);

CREATE TABLE foot.tackling (
	id 					bigserial PRIMARY KEY,
	tackling_percentage int,
	won 				int,
	lost 				int,
	fouls 				int,
	penalties_conceded 	int
);

CREATE TABLE foot.positioning (
	id 				bigserial PRIMARY KEY,
	interceptions 	int,
	blocks 			int,
	out_of_position int
);

CREATE TABLE foot.ball_retention (
	id 				bigserial PRIMARY KEY,
	possession_won 	int,
	possession_lost int,
	clearances      int,
	headers_won 	int,
	headers_lost 	int
);

CREATE TABLE foot.player (
	id 						bigserial PRIMARY KEY,
	end_user_id 			bigint not null,
	first_name 				varchar(50),
	surname 				varchar(50),
	known_as 				varchar(50),
	commentary_name 		varchar(50),
	kit_name 				varchar(50),
	kit_number 				bigint,
	nationality_id 			int not null,
	birth_date 				timestamp,
	is_manager 				boolean,
	is_free_agent 			boolean,
	contract_id 			bigint,
	team_id 				int,
	player_statistics_id    bigint not null
);

CREATE TABLE foot.player_statistics (
	id 					bigserial PRIMARY KEY,
	player_id 			bigint,
	shooting_id 		bigint,
	passes_id 			bigint,
	movement_id 		bigint,
	tackling_id 		bigint,
	positioning_id 		bigint,
	ball_retention_id 	bigint
);

CREATE TABLE foot.scorer (
	id 			bigserial PRIMARY KEY,
	player_id 	bigint,
	game_id 	bigint
);

CREATE TABLE foot.player_post (
    id  bigserial PRIMARY KEY,
    player_id   bigint,
    post_id     int,
    is_primary  boolean
);


--- Foreign Keys
ALTER TABLE foot.championship
    ADD CONSTRAINT fk$championship$season FOREIGN KEY (season_id)
REFERENCES foot.season(id);

ALTER TABLE foot.party
    ADD CONSTRAINT fk$party$season FOREIGN KEY (season_id)
REFERENCES foot.season(id);

ALTER TABLE foot.party
    ADD CONSTRAINT fk$party$championship FOREIGN KEY (championship_id)
REFERENCES foot.championship(id);

ALTER TABLE foot.game
    ADD CONSTRAINT fk$game$season FOREIGN KEY (season_id)
REFERENCES foot.season(id);

ALTER TABLE foot.game
    ADD CONSTRAINT fk$game$party FOREIGN KEY (party_id)
REFERENCES foot.party(id);

ALTER TABLE foot.game
    ADD CONSTRAINT fk$game$team_a FOREIGN KEY (team_a_id)
REFERENCES foot.team(id);

ALTER TABLE foot.game
    ADD CONSTRAINT fk$game$team_b FOREIGN KEY (team_b_id)
REFERENCES foot.team(id);

ALTER TABLE foot.team_statistics
    ADD CONSTRAINT fk$team_statistics$team FOREIGN KEY (team_id)
REFERENCES foot.team(id);

ALTER TABLE foot.team_statistics
    ADD CONSTRAINT fk$team_statistics$season FOREIGN KEY (season_id)
REFERENCES foot.season(id);

ALTER TABLE foot.party_team
    ADD CONSTRAINT fk$party_team$party FOREIGN KEY (party_id)
REFERENCES foot.party(id);

ALTER TABLE foot.party_team
    ADD CONSTRAINT fk$party_team$team FOREIGN KEY (team_id)
REFERENCES foot.team(id);

ALTER TABLE foot.player
    ADD CONSTRAINT fk$player$end_user FOREIGN KEY (end_user_id)
REFERENCES foot.end_user(id);

ALTER TABLE foot.player
    ADD CONSTRAINT fk$player$player_statistics FOREIGN KEY (player_statistics_id)
REFERENCES foot.player_statistics(id);

ALTER TABLE foot.player
    ADD CONSTRAINT fk$player$nationality FOREIGN KEY (nationality_id)
REFERENCES foot.nationality(id);

ALTER TABLE foot.player
    ADD CONSTRAINT fk$player$contract FOREIGN KEY (contract_id)
REFERENCES foot.contract(id);

ALTER TABLE foot.player
    ADD CONSTRAINT fk$player$team FOREIGN KEY (team_id)
REFERENCES foot.team(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$player FOREIGN KEY (player_id)
REFERENCES foot.player(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$shooting FOREIGN KEY (shooting_id)
REFERENCES foot.shooting(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$passes FOREIGN KEY (passes_id)
REFERENCES foot.passes(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$movement FOREIGN KEY (movement_id)
REFERENCES foot.movement(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$tackling FOREIGN KEY (tackling_id)
REFERENCES foot.tackling(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$positioning FOREIGN KEY (positioning_id)
REFERENCES foot.positioning(id);

ALTER TABLE foot.player_statistics
    ADD CONSTRAINT fk$player_statistics$ball_retention FOREIGN KEY (ball_retention_id)
REFERENCES foot.ball_retention(id);

ALTER TABLE foot.scorer
    ADD CONSTRAINT fk$scorer$player FOREIGN KEY (player_id)
REFERENCES foot.player(id);

ALTER TABLE foot.scorer
    ADD CONSTRAINT fk$scorer$game FOREIGN KEY (game_id)
REFERENCES foot.game(id);

ALTER TABLE foot.player_post
    ADD CONSTRAINT fk$player_post$player FOREIGN KEY (player_id)
REFERENCES foot.player(id);

ALTER TABLE foot.player_post
    ADD CONSTRAINT fk$player_post$post FOREIGN KEY (post_id)
REFERENCES foot.post(id);