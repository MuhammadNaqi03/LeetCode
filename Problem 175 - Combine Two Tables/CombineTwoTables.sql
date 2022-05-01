SELECT p.FirstName, p.LastName, a.City, a.State
FROM Person p
-- We have to consider that all name might not be
-- associated with address
-- So we need to find null value for those
LEFT JOIN Address a
ON p.PersonId = a.PersonId
