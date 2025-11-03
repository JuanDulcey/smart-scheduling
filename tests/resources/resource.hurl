# ======================================================
# Smart Scheduling - API Test Suite for Resource entity
# Autor: Juan Esteban Dulcey Gómez
# Fecha: 2025-11-01
# Descripción: Pruebas completas CRUD sobre /api/resources
# ======================================================

# ======================================================
# 1️⃣ CREAR un nuevo Resource
# ======================================================

POST http://localhost:8080/api/resources
Content-Type: application/json

{
  "siteId": "11111111-1111-1111-1111-111111111111",
  "name": "Consultorio 101",
  "type": "Sala Médica",
  "active": true
}

HTTP 201
[Asserts]
jsonpath "$.id" exists
jsonpath "$.name" == "Consultorio 101"
jsonpath "$.active" == true

# Guardar el ID generado para las siguientes pruebas
[Captures]
resource_id: jsonpath "$.id"

# ======================================================
# 2️⃣ OBTENER todos los Resources
# ======================================================

GET http://localhost:8080/api/resources
HTTP 200
[Asserts]
jsonpath "$" count >= 1

# ======================================================
# 3️⃣ OBTENER un Resource específico
# ======================================================

GET http://localhost:8080/api/resources/{{resource_id}}
HTTP 200
[Asserts]
jsonpath "$.id" == "{{resource_id}}"
jsonpath "$.name" == "Consultorio 101"

# ======================================================
# 4️⃣ ACTUALIZAR un Resource existente
# ======================================================

PUT http://localhost:8080/api/resources/{{resource_id}}
Content-Type: application/json

{
  "siteId": "11111111-1111-1111-1111-111111111111",
  "name": "Consultorio 102",
  "type": "Sala de Terapia",
  "active": false
}

HTTP 200
[Asserts]
jsonpath "$.name" == "Consultorio 102"
jsonpath "$.type" == "Sala de Terapia"
jsonpath "$.active" == false

# ======================================================
# 5️⃣ ELIMINAR un Resource
# ======================================================

DELETE http://localhost:8080/api/resources/{{resource_id}}
HTTP 204

# ======================================================
# 6️⃣ VERIFICAR que el Resource fue eliminado (opcional)
# ======================================================

GET http://localhost:8080/api/resources/{{resource_id}}
HTTP 404
