/**
 * This software was developed and / or modified by NOAA/NWS/OCP/ASDT
 *
<<<<<<< HEAD
 * Create climate tablespace and databse 
 * 
 */
\set ON_ERROR_STOP 1
CREATE TABLESPACE climate OWNER awipsadmin LOCATION '%{tablespace_dir}%/climate';
COMMENT ON TABLESPACE climate IS 'Climate Database tablespace';
CREATE DATABASE climate OWNER awipsadmin TABLESPACE climate;
=======
 * Create climate tablespace and database 
 * 
 */
\set ON_ERROR_STOP 1
DROP DATABASE IF EXISTS climate;
DROP TABLESPACE IF EXISTS climate;
CREATE TABLESPACE climate OWNER awipsadmin LOCATION '%{tablespace_dir}%/climate';
COMMENT ON TABLESPACE climate IS 'Climate Database tablespace';
CREATE DATABASE climate OWNER awipsadmin TABLESPACE climate;
>>>>>>> 3a1a5c9814b49f276bea4ebd9e584974d6ea7a11
