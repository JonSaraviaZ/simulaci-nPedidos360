package cl.duoc.pedidos360.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PedidosController {

    @GetMapping("/api/pedidos")
    public List<Map<String, Object>> listarPedidos() {

        return List.of(
            Map.of("id", 1, "producto", "Notebook", "estado", "Pendiente"),
            Map.of("id", 2, "producto", "Monitor", "estado", "Despachado")
        );
    }

    //parametro para traer un pedido por id
    @GetMapping("/api/pedidos/{id}")
    public Map<String, Object> obtenerPedidoPorId(@PathVariable int id) {
        // Simulación de datos de pedidos
        List<Map<String, Object>> pedidos = List.of(
            Map.of("id", 1, "producto", "Notebook", "estado", "Pendiente"),
            Map.of("id", 2, "producto", "Monitor", "estado", "Despachado")
        );
        return pedidos.stream()
                .filter(pedido -> pedido.get("id").equals(id))
                .findFirst()
                .orElse(Map.of());
    }
}

